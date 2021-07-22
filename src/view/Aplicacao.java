package br.com.unisuam.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.unisuam.dao.UsuarioDAO;
import br.com.unisuam.model.Usuario;

public class Aplicacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	UsuarioDAO usuarioDao = new UsuarioDAO();
	Usuario usuario = new Usuario();
	public static Aplicacao frame = new Aplicacao();
	private JTextField textField_Matricula;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Aplicacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TELA DE LOGIN");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 508, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("MATRICULA :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(82, 95, 120, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SENHA :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(118, 157, 84, 31);
		contentPane.add(lblNewLabel_1_1);
		
		textField_Matricula = new JTextField();
		textField_Matricula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_Matricula.setBounds(214, 95, 144, 28);
		contentPane.add(textField_Matricula);
		textField_Matricula.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 157, 144, 28);
		contentPane.add(passwordField);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				Cadastro cadastro = new Cadastro();
			}
		});
		btnCadastrar.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnCadastrar.setBounds(135, 248, 109, 31);
		btnCadastrar.setFocusable(false);
		contentPane.add(btnCadastrar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario.setMatricula(Integer.parseInt(textField_Matricula.getText()));
				usuario.setSenha(new String(passwordField.getPassword()));
				if(usuario == usuarioDao.login(usuario)) {
					frame.setVisible(false);
					Menu menu = new Menu(usuario);
				}
			}
		});
		btnEnviar.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnEnviar.setBounds(277, 248, 109, 31);
		btnEnviar.setFocusable(false);
		contentPane.add(btnEnviar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnSair.setBounds(207, 309, 109, 31);
		btnSair.setFocusable(false);
		contentPane.add(btnSair);
		
	}
}
