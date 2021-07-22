package view;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dao.UsuarioDAO;
import model.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Cadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Nome;
	UsuarioDAO usuarioDao = new UsuarioDAO();
	Usuario usuario = new Usuario();
	private JPasswordField passwordField;
	
	public Cadastro() {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 550, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRO");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 508, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NOME :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(118, 95, 84, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("SENHA :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(118, 157, 84, 31);
		contentPane.add(lblNewLabel_1_1);
										
		textField_Nome = new JTextField();
		textField_Nome.setBounds(214, 95, 144, 28);
		contentPane.add(textField_Nome);
		textField_Nome.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 157, 144, 28);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Aplicacao.frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(135, 261, 109, 31);
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Enviar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario.setNome(textField_Nome.getText());
				usuario.setSenha(new String(passwordField.getPassword()));
				usuarioDao.save(usuario);
				setVisible(false);
				Aplicacao.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(277, 261, 109, 31);
		btnNewButton_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton_1.setFocusable(false);
		contentPane.add(btnNewButton_1);
		
		

	}
}
