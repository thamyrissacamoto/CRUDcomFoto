package GUIs;

import Entidades.Mustang;
import Controles.MustangControle;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import tools.CopiarArquivos;
import tools.GetDiretorioDaAplicacao;
import tools.ImagemAjustada;

/**
 *
 * @author thamyris 01/11/2020 - 21:13:13
 */
public class MustangGUI extends JDialog {

    Container cp;
    JPanel pnNorte = new JPanel();
    JPanel pnCentro = new JPanel();
    JPanel pnSul = new JPanel();
    JPanel pnLeste = new JPanel(new BorderLayout());
    JPanel pnLesteA = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel pnLesteB = new JPanel(new GridLayout(1, 1));
    JButton btBuscar = new JButton("Buscar");
    JButton btAdicionar = new JButton("Adicionar");
    JButton btSalvar = new JButton("Salvar");
    JButton btAlterar = new JButton("Alterar");
    JButton btExcluir = new JButton("Excluir");
    JButton btListar = new JButton("Listar");
    JButton btCancelar = new JButton("Cancelar");
    JButton btAdicionarFoto = new JButton("Adicionar/alterar foto");
    JButton btRemoverFoto = new JButton("Remover foto");

    String acao = "";
    private JScrollPane scrollTabela = new JScrollPane();

    private JPanel pnAvisos = new JPanel(new GridLayout(1, 1));
    private JPanel pnListagem = new JPanel(new GridLayout(1, 1));
    private JPanel pnVazio = new JPanel(new GridLayout(6, 1));

    private CardLayout cardLayout;

//////////////////// - mutável - /////////////////////////
    JLabel lbId = new JLabel("Id");
    JTextField tfId = new JTextField(30);
    JLabel lbNome = new JLabel("Nome");
    JTextField tfNome = new JTextField(50);
    JLabel lbCaminhoFoto = new JLabel("");
    JLabel lbFoto = new JLabel();
    MustangControle controle = new MustangControle();
    Mustang mustang = new Mustang();
    String[] colunas = new String[]{"id", "nome", "foto"};
    String[][] dados = new String[0][colunas.length];

    DefaultTableModel model = new DefaultTableModel(dados, colunas);
    JTable tabela = new JTable(model);
    ImagemAjustada imagemAjustada = new ImagemAjustada();
    GetDiretorioDaAplicacao diretorioDaAplicacao = new GetDiretorioDaAplicacao();
    String dirApp = diretorioDaAplicacao.getDiretorioDaAplicacao();
    String origem = dirApp + "/src/fotos/padrao.png";
    int tamX = 300;
    int tamY = 300;
    String temFoto = "";

    public MustangGUI() {

        lbFoto.setIcon(imagemAjustada.getImagemAjustada(origem, tamX, tamY));
        tfNome.setEditable(false);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        cp = getContentPane();
        cp.setLayout(new BorderLayout());
        setTitle("CRUD - Mustang");

        cp.add(pnNorte, BorderLayout.NORTH);
        cp.add(pnCentro, BorderLayout.CENTER);
        cp.add(pnSul, BorderLayout.SOUTH);
        cp.add(pnLeste, BorderLayout.EAST);
        pnLeste.add(pnLesteA, BorderLayout.NORTH);
        pnLeste.add(pnLesteB, BorderLayout.CENTER);
        pnLesteA.add(btAdicionarFoto);
        pnLesteA.add(btRemoverFoto);
        btAdicionarFoto.setVisible(false);
        btRemoverFoto.setVisible(false);

        pnNorte.setBackground(Color.BLACK);
        lbId.setForeground(Color.WHITE);
        tfId.setForeground(Color.WHITE);
        tfId.setBackground(Color.DARK_GRAY);
        btAdicionar.setBackground(Color.BLACK);
        btAlterar.setBackground(Color.BLACK);
        btExcluir.setBackground(Color.BLACK);
        btListar.setBackground(Color.BLACK);
        btSalvar.setBackground(Color.BLACK);
        btCancelar.setBackground(Color.BLACK);
        btAdicionar.setBackground(Color.BLACK);
        btAlterar.setBackground(Color.BLACK);
        btExcluir.setBackground(Color.BLACK);
        btRemoverFoto.setBackground(Color.BLACK);
        btAdicionarFoto.setBackground(Color.BLACK);
        btListar.setBackground(Color.BLACK);
        btSalvar.setBackground(Color.BLACK);
        btCancelar.setBackground(Color.BLACK);
        btBuscar.setBackground(Color.BLACK);
        btAdicionar.setForeground(Color.WHITE);
        btBuscar.setForeground(Color.WHITE);
        btAdicionar.setForeground(Color.WHITE);
        btAlterar.setForeground(Color.WHITE);
        btExcluir.setForeground(Color.WHITE);
        btListar.setForeground(Color.WHITE);
        btSalvar.setForeground(Color.WHITE);
        btCancelar.setForeground(Color.WHITE);
        btRemoverFoto.setForeground(Color.WHITE);
        btAdicionarFoto.setForeground(Color.WHITE);
        lbId.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        tfId.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        btAdicionar.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        btAlterar.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        btExcluir.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        btListar.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        btSalvar.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        btCancelar.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        btBuscar.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        lbNome.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        tfNome.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        btRemoverFoto.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        btAdicionarFoto.setFont(new Font("SANS_SERIF", Font.BOLD, 14));        
        tfNome.setBorder(BorderFactory.createLineBorder(Color.RED));
        tfId.setBorder(BorderFactory.createLineBorder(Color.RED));

        pnNorte.setLayout(new FlowLayout(FlowLayout.LEFT));
        pnNorte.add(lbId);
        pnNorte.add(tfId);
        pnNorte.add(btBuscar);
        pnNorte.add(btAdicionar);
        pnNorte.add(btAlterar);
        pnNorte.add(btExcluir);
        pnNorte.add(btListar);
        pnNorte.add(btSalvar);
        pnNorte.add(btCancelar);

        btSalvar.setVisible(false);
        btAdicionar.setVisible(false);
        btAlterar.setVisible(false);
        btExcluir.setVisible(false);
        btCancelar.setVisible(false);
        
        pnCentro.setBackground(Color.BLACK);
        pnLesteB.setBackground(Color.BLACK);
        pnLesteA.setBackground(Color.BLACK);
        lbCaminhoFoto.setForeground(Color.WHITE);
        lbNome.setForeground(Color.WHITE);
        tfNome.setForeground(Color.WHITE);
        tfNome.setBackground(Color.DARK_GRAY);
        pnCentro.setLayout(new GridLayout(colunas.length - 1, 2));
        pnCentro.add(lbNome);
        pnCentro.add(tfNome);
        pnCentro.add(lbCaminhoFoto);
        pnLesteB.add(lbFoto);
        cardLayout = new CardLayout();
        pnSul.setLayout(cardLayout);
        pnSul.setBackground(Color.BLACK);
        pnAvisos.setBackground(Color.BLACK);
        tabela.setBackground(Color.BLACK);
        tabela.setForeground(Color.WHITE);

        for (int i = 0; i < 5; i++) {
            pnVazio.add(new JLabel(" "));
        }
        pnSul.add(pnVazio, "vazio");
        pnSul.add(pnAvisos, "avisos");
        pnSul.add(pnListagem, "listagem");
        tabela.setEnabled(false);

        pnAvisos.add(new JLabel("Avisos"));
        String caminho = "Mustang.csv";
        //carregar dados do HD para memória RAM
        controle.carregarDados(caminho);

// listener Buscar
        btBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(pnSul, "avisos");
                mustang = controle.buscar(Integer.valueOf(tfId.getText()));
                if (mustang != null) {//achou o mustang na lista
                    //mostrar
                    btAdicionar.setVisible(false);
                    btAlterar.setVisible(true);
                    btExcluir.setVisible(true);
                    tfNome.setText(mustang.getNome());
                    tfNome.setEditable(false);
                    String c = dirApp + "/src/fotos/" + mustang.getId() + ".png";
                    if (mustang.getFoto().equals("Sim")) { //tem foto
                        ImageIcon ii = imagemAjustada.getImagemAjustada(c, tamY, tamY);
                        lbFoto.setIcon(ii);
                        lbCaminhoFoto.setText(dirApp + "/src/fotos/" + mustang.getId() + ".png");
                    } else {
                        c = dirApp + "/src/fotos/padrao.png";
                        ImageIcon ii = imagemAjustada.getImagemAjustada(c, tamY, tamY);
                        lbFoto.setIcon(ii);
                    }
                    lbCaminhoFoto.setText(c);
                    tfId.selectAll();
                    tfId.requestFocus();
                } else {//não achou na lista
                    //mostrar botão incluir
                    btAdicionar.setVisible(true);
                    btAlterar.setVisible(false);
                    btExcluir.setVisible(false);
                    tfNome.setText("");
                    tfNome.setEditable(false);

                    ImageIcon ii = imagemAjustada.getImagemAjustada(dirApp + "/src/fotos/padrao.png", tamX, tamY);
                    lbFoto.setIcon(ii);
                    lbCaminhoFoto.setText(dirApp + "/src/fotos/padrao.png");
                }
            }
        });

// listener Adicionar
        btAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tfId.setEnabled(false);
                tfNome.requestFocus();
                tfNome.setEditable(true);
                btAdicionar.setVisible(false);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btBuscar.setVisible(false);
                btListar.setVisible(false);
                btAdicionarFoto.setVisible(true);
                btRemoverFoto.setVisible(true);
                acao = "adicionar";
                temFoto = "Não";
            }
        });

// listener Salvar
        btSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CopiarArquivos copiarArquivos = new CopiarArquivos();
                //salvar a imagem

                if (acao.equals("adicionar")) {
                    mustang = new Mustang();
                }
                Mustang mustangAntigo = mustang;
                mustang.setId(Integer.valueOf(tfId.getText()));
                mustang.setNome(tfNome.getText());
                mustang.setFoto(temFoto);

                //copiar a foto da origem para a pasta destino no projeto
                String destino = dirApp + "/src/fotos/";
                destino = destino + mustang.getId() + ".png";

                copiarArquivos.copiar(lbCaminhoFoto.getText(), destino);

                if (acao.equals("adicionar")) {
                    controle.adicionar(mustang);
                } else {
                    mustang.setFoto(temFoto);
                    controle.alterar(mustang, mustangAntigo);
                }
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                tfId.setEnabled(true);
                tfId.setEditable(true);
                tfId.requestFocus();
                tfId.setText("");
                tfNome.setText("");
                btAdicionarFoto.setVisible(false);
                btRemoverFoto.setVisible(false);
                ImageIcon ii = imagemAjustada.getImagemAjustada(dirApp + "/src/fotos/padrao.png", tamX, tamY);
                lbFoto.setIcon(ii);
                lbCaminhoFoto.setText(dirApp + "/src/fotos/padrao.png");

            }
        });

// listener Alterar
        btAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btBuscar.setVisible(false);
                btAlterar.setVisible(false);
                tfId.setEditable(false);
                tfNome.requestFocus();
                tfNome.setEditable(true);
                btSalvar.setVisible(true);
                btCancelar.setVisible(true);
                btListar.setVisible(false);
                tfId.setEnabled(true);
                btExcluir.setVisible(false);
                btAdicionarFoto.setVisible(true);
                btRemoverFoto.setVisible(true);
                acao = "alterar";

            }
        });

// listener Excluir
        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int response = JOptionPane.showConfirmDialog(cp, "Confirme a exclusão?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                btExcluir.setVisible(false);
                tfId.setEnabled(true);
                tfId.setEditable(true);
                tfId.requestFocus();
                tfId.setText("");
                tfNome.setText("");
                tfNome.setEditable(false);
                lbFoto.setText("");
                btAlterar.setVisible(false);
                if (response == JOptionPane.YES_OPTION) {
                    controle.excluir(mustang);
                }
                //excluir a foto
                String cc = lbCaminhoFoto.getText();
                File oArquivo = new File(cc.trim());
                if (oArquivo.exists()) {
                    oArquivo.delete();//exclui a foto
                    origem = dirApp + "/src/fotos/padrao.png";
                    ImageIcon ii = imagemAjustada.getImagemAjustada(dirApp + "/src/fotos/padrao.png", tamX, tamY);
                    lbFoto.setIcon(ii);
                } else {
                    System.out.println("não achou");
                }
            }
        });
// listener Listar
        btListar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                List<Mustang> listaMustang = controle.listar();
                String[] colunas = new String[]{"id", "nome", "foto"};
                String[][] dados = new String[listaMustang.size()][colunas.length];
                String aux[];
                for (int i = 0; i < listaMustang.size(); i++) {
                    aux = listaMustang.get(i).toString().split(";");
                    for (int j = 0; j < colunas.length; j++) {
                        dados[i][j] = aux[j];
                    }
                }
                cardLayout.show(pnSul, "listagem");
                scrollTabela.setPreferredSize(tabela.getPreferredSize());
                pnListagem.add(scrollTabela);
                scrollTabela.setViewportView(tabela);
                model.setDataVector(dados, colunas);

                btAlterar.setVisible(false);
                btExcluir.setVisible(false);
                btAdicionar.setVisible(false);

            }
        }
        );

// listener Cancelar
        btCancelar.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btCancelar.setVisible(false);
                tfId.setText("");
                tfId.requestFocus();
                tfId.setEnabled(true);
                tfId.setEditable(true);
                tfNome.setText("");
                tfNome.setEditable(false);
                lbFoto.setText("");
//                lbFoto.setEditable(false);
                btBuscar.setVisible(true);
                btListar.setVisible(true);
                btSalvar.setVisible(false);
                btCancelar.setVisible(false);
                btAdicionarFoto.setVisible(false);
                btRemoverFoto.setVisible(false);
            }
        });
        
        btAdicionarFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if (fc.showOpenDialog(cp) == JFileChooser.APPROVE_OPTION) {
                    File img = fc.getSelectedFile();
                    origem = fc.getSelectedFile().getAbsolutePath();

                    try {
                        lbFoto.setIcon(imagemAjustada.getImagemAjustada(origem, tamX, tamY));
                        lbCaminhoFoto.setText(origem);
                        temFoto = "Sim";
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(cp, "Erro ao carregar a imagem");
                    }
                }
            }
        });        

        btRemoverFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int response = JOptionPane.showConfirmDialog(cp, "Confirma a remoção da foto?", "Confirm",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

                if (response == JOptionPane.YES_OPTION) {
                    //excluir a foto
                    System.out.println("arq > " + lbCaminhoFoto.getText());
                    File oArquivo = new File(lbCaminhoFoto.getText().trim());
                    if (oArquivo.exists()) {
                        new File(lbCaminhoFoto.getText()).delete();//exclui a foto
                        origem = dirApp + "/src/fotos/padrao.png";
                        ImageIcon ii = imagemAjustada.getImagemAjustada(dirApp + "/src/fotos/padrao.png", tamX, tamY);
                        lbFoto.setIcon(ii);
                        temFoto = "Não";
                    }
                }
            }
        });
        
// listener ao fechar o programa
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //antes de sair, salvar a lista em armazenamento permanente
                controle.gravarLista(caminho);
                // Sai da classe
                dispose();
            }
        });

        setModal(true);
        pack();
        setLocationRelativeTo(null);//centraliza na tela
        setVisible(true);
    }//fim do contrutor de GUI
} //fim da classe
