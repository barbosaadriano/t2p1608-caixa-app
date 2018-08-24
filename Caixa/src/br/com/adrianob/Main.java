package br.com.adrianob;

import br.com.adrianob.dao.CaixaDao;
import br.com.adrianob.model.Caixa;
import br.com.adrianob.view.AdrianoCellRenderer;
import br.com.adrianob.view.CaixaTableModel;
import br.com.adrianob.view.EditViewCaixa;
import br.com.adrianob.view.ListViewCaixa;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author drink
 */
public class Main implements ActionListener {

    private ListViewCaixa lvc = null;
    private CaixaDao cd = null;
    private EditViewCaixa edc = null;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().open();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("caixa.search")) {
            lvc.getTabela().setModel(new CaixaTableModel(cd.getAll("")));
            lvc.getTabela().setDefaultRenderer(Object.class, new AdrianoCellRenderer());
            lvc.getTabela().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int rowAtPoint = lvc.getTabela().rowAtPoint(e.getPoint());
                        Main.this.actionPerformed(new ActionEvent(e.getSource(), rowAtPoint, "tbl.clique"));
                    }
                    super.mouseClicked(e);
                }

            });
        }
        if (e.getActionCommand().equals("caixa.add")) {
            this.edc = new EditViewCaixa(Main.this);
            Caixa caixa = cd.getCaixa(new Date());
            if (caixa.getStatus().toString().equals(Caixa.StatusCaixa.FECHADO.toString())) {
                JOptionPane.showMessageDialog(edc, "Este caixa já se encontra fechado!");
                if (JOptionPane.showConfirmDialog(edc, "Deseja continuar e reabrir o caixa?", "confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                        == JOptionPane.NO_OPTION) {
                    return;
                }
            }
            if (caixa == null) {
                caixa = new Caixa();
            }
            this.edc.setDataFromCaixa(caixa);
            this.edc.setVisible(true);
        }
        if (e.getActionCommand().equals("caixa.salvar")) {
            try {
                cd.salvar(edc.getCaixaFromData());
                JOptionPane.showMessageDialog(edc, "Salvo com sucesso!");
                this.actionPerformed(new ActionEvent(edc, 0, "caixa.search"));
                edc.dispose();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
        if (e.getActionCommand().equals("caixa.fechar")) {
            Caixa caixa = edc.getCaixaFromData();
            if (caixa.getStatus().equals(Caixa.StatusCaixa.FECHADO)) {
                JOptionPane.showMessageDialog(edc, "Caixa já está fechado!");
                return;
            }
            caixa.setStatus(Caixa.StatusCaixa.FECHADO);
            cd.salvar(caixa);
            JOptionPane.showMessageDialog(edc, "Salvo fechado com sucesso!");
            this.actionPerformed(new ActionEvent(edc, 0, "caixa.search"));
            edc.dispose();
        }
        if (e.getActionCommand().equals("tbl.clique")) {
            System.out.println(e.getID());
            Object dt = lvc.getTabela().getValueAt(e.getID(), 0);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            try {
                Date data = sdf.parse((String) dt);
                Caixa cx = cd.getCaixa(data);
                if (cx.getStatus().toString().equals(Caixa.StatusCaixa.FECHADO.toString())) {
                    JOptionPane.showMessageDialog(edc, "Este caixa já se encontra fechado!");
                    if (JOptionPane.showConfirmDialog(edc, "Deseja continuar e reabrir o caixa?", "confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE)
                            == JOptionPane.NO_OPTION) {
                        return;
                    }
                }
                if (cx == null) {
                    cx = new Caixa();
                }
                if (this.edc == null) {
                    this.edc = new EditViewCaixa(this);
                }
                this.edc.setDataFromCaixa(cx);
                this.edc.setVisible(true);
            } catch (ParseException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private void open() {
        Properties config = new Properties();
        config.put("user", "devel");
        config.put("password", "developer");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn
                    = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/singleton",
                            config
                    );

            cd = new CaixaDao((com.mysql.jdbc.Connection) conn);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        lvc = new ListViewCaixa(this);
        lvc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lvc.setVisible(true);
    }

}
