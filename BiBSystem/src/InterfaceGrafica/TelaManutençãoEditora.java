/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfaceGrafica;

import TipoDados.Editora;
import TipoDados.Livro;
import java.awt.event.ActionEvent;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * a
 *
 * @author Fernando TeTz
 */
public class TelaManutençãoEditora extends ModeloManutenção {

    ArrayList<Editora> editoras = new ArrayList<>();
    ArrayList<Livro> livros = new ArrayList<>();
    public static Editora editora;
    String pesquisa[] = {"Razão Social", "ID"};

    public TelaManutençãoEditora() throws Exception {
        try {
            lerArquivo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Arquivo 'ArqEditoras.dad' não encontrado. Um novo arquivo será criado.",
                    "Tela de erro", JOptionPane.ERROR_MESSAGE);
            gravaArquivo();
        }
        montaCombo();
        initComponents();
        tabelaEditoras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaEditoras.getColumnModel().getColumn(0).setMinWidth(30);
        tabelaEditoras.getColumnModel().getColumn(0).setMaxWidth(50);
        editora = new Editora();
    }

    private void montaCombo() {
        cbPesquisa.removeAllItems();
        for (String pesquisa1 : pesquisa) {
            cbPesquisa.addItem(pesquisa1);
        }
        cbPesquisa.setSelectedIndex(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEditoras = new javax.swing.JTable();

        setTitle("Manutenção de editoras");

        tabelaEditoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Razão Social"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEditoras.getTableHeader().setReorderingAllowed(false);
        tabelaEditoras.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabelaEditoras.getColumnModel().getColumn(1).setPreferredWidth(200);
        jScrollPane1.setViewportView(tabelaEditoras);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lerArquivo() throws Exception {
        Editora editorax = null;
        editoras.clear();
        ObjectInputStream arquivo = null;
        try {
            arquivo = new ObjectInputStream(new FileInputStream("ArqEditoras.dad"));
            do {
                editorax = (Editora) arquivo.readObject();
                editoras.add(editorax);
            } while (editorax != null);
        } catch (EOFException e) {
            arquivo.close();
        }
    }

    private void lerArquivoLivros() throws Exception {
        Livro livrox = null;
        livros.clear();
        ObjectInputStream arquivo = null;
        try {
            arquivo = new ObjectInputStream(new FileInputStream("ArqLivros.dad"));
            do {
                livrox = (Livro) arquivo.readObject();
                livros.add(livrox);
            } while (livrox != null);
        } catch (EOFException e) {
            arquivo.close();
        }
    }

    @Override
    public void bNovoActionListener(ActionEvent evt) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaEditoras.getModel();
        try {
            TelaAdicionarEditora telaedit = new TelaAdicionarEditora();
            telaedit.setVisible(true);
        } catch (Exception ae) {
        }
        try {
            lerArquivo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }

        for (int x = 0; x < editoras.size(); x++) {
            Object[] linhax = {editoras.get(x).getIdEditora(), editoras.get(x).getRazaoSocial()};
            modelo.addRow(linhax);
        }
    }

    @Override
    public void bEditarActionListener(ActionEvent evt) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaEditoras.getModel();
        int linha = tabelaEditoras.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma editora selecionada.\n"
                    + "Por favor selecione uma editora para ser editada.", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idEdit = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
        for (int x = 0; x < editoras.size(); x++) {
            if (editoras.get(x).getIdEditora() == idEdit) {
                editora = editoras.get(x);
                break;
            }
        }
        try {
            TelaEditarEditora telaedit = new TelaEditarEditora();
            telaedit.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir tela de editar editoras." + ex.getMessage(),
                    "Tela de erro", JOptionPane.ERROR_MESSAGE);
        }

        try {
            lerArquivo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }

        for (int x = 0; x < editoras.size(); x++) {
            Object[] linhax = {editoras.get(x).getIdEditora(), editoras.get(x).getRazaoSocial()};
            modelo.addRow(linhax);
        }
    }

    @Override
    public void bSairActionListener(ActionEvent evt) {
        int result;
        try {
            result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "SAIR", JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                TelaInicial.max = 0;
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Tela de erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void txPesquisa() {
        try {
            lerArquivo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir arquivo", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        int tipoPesquisa = cbPesquisa.getSelectedIndex();
        DefaultTableModel modelo = (DefaultTableModel) tabelaEditoras.getModel();
        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }
        if (tipoPesquisa == 0) {
            if (!(tPesquisa.getText().isEmpty())) {
                for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                    modelo.removeRow(k);
                }
                for (int i = 0; i < editoras.size(); i++) {
                    if (editoras.get(i).getRazaoSocial().contains(tPesquisa.getText())) {
                        Object[] linha = {editoras.get(i).getIdEditora(), editoras.get(i).getRazaoSocial()};
                        modelo.addRow(linha);
                    }
                }
            }
        } else { //Pesquisa por ID
            for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
                modelo.removeRow(k);
            }
            for (int x = 0; x < editoras.size(); x++) {
                if (Integer.toString(editoras.get(x).getIdEditora()).equals(tPesquisa.getText())) {
                    Object[] linha = {editoras.get(x).getIdEditora(), editoras.get(x).getRazaoSocial()};
                    modelo.addRow(linha);
                }
            }
        }
    }

    @Override
    public void bMostrarTodosActionListener(ActionEvent evt) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaEditoras.getModel();
        try {
            lerArquivo();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi encontrado editoras cadastradas.", "NÃO ENCONTRADO", JOptionPane.ERROR_MESSAGE);
        }
        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }

        for (int x = 0; x < editoras.size(); x++) {
            Object[] linha = {editoras.get(x).getIdEditora(), editoras.get(x).getRazaoSocial()};
            modelo.addRow(linha);
        }
    }

    @Override
    public void bLimparTudoActionListener(ActionEvent evt) {
        DefaultTableModel modelo = (DefaultTableModel) tabelaEditoras.getModel();

        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }
        tPesquisa.setText("");
    }

    @Override
    public void bExcluirActionListener(ActionEvent evt) {
        try {
            lerArquivo();
            lerArquivoLivros();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ler arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        DefaultTableModel modelo = (DefaultTableModel) tabelaEditoras.getModel();
        int linha = tabelaEditoras.getSelectedRow();
        if (linha == -1) {
            JOptionPane.showMessageDialog(null, "Nenhuma editora selecionada.\n"
                    + "Por favor selecione uma editora para ser excluída.", "ERRO", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int idRemove = Integer.parseInt(modelo.getValueAt(linha, 0).toString());
        for (int x = 0; x < editoras.size(); x++) {
            if (editoras.get(x).getIdEditora() == idRemove) {
                int result = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir '"
                        + editoras.get(x).getRazaoSocial() + "' ?", "EXCLUIR EDITORA", JOptionPane.YES_NO_OPTION);
                if (result == 0) {
                    for (Livro livr : livros) { //Percorre todos os livros
                        if (livr.getEditora().getIdEditora() == idRemove) {
                            JOptionPane.showMessageDialog(null, "Existe livro cadastrado com a editora "
                                    + livr.getEditora().getRazaoSocial() + ". Não é possível exclui-la.",
                                    "EXCLUSÃO NÃO PERMITIDA.", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Editora '" + editoras.get(x).getRazaoSocial()
                            + "' excluída com sucesso.", "EXCLUIR EDITORA", JOptionPane.INFORMATION_MESSAGE);
                    editoras.remove(x);
                    try {
                        gravaArquivo();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Erro ao gravar no arquivo.", "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
        }
        for (int k = 0; k < modelo.getRowCount();) { //Limpa tabela
            modelo.removeRow(k);
        }

        for (int x = 0; x < editoras.size(); x++) {
            Object[] ln = {editoras.get(x).getIdEditora(), editoras.get(x).getRazaoSocial()};
            modelo.addRow(ln);
        }
    }

    private void gravaArquivo() throws Exception {
        try (ObjectOutputStream arquivo = new ObjectOutputStream(new FileOutputStream("ArqEditoras.dad"))) {
            for (Editora editorax : editoras) {
                arquivo.writeObject(editorax);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tabelaEditoras;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mudouCB() {
    }

}
