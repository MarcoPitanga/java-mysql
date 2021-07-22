package br.com.unisuam.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.unisuam.model.Usuario;

public class Menu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public Menu(Usuario usuario) {
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 250, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_menu = new JPanel();
		panel_menu.setBackground(new Color(192, 192, 192));
		panel_menu.setBounds(0, 0, 129, 353);
		contentPane.add(panel_menu);
		panel_menu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MENU");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 105, 56);
		panel_menu.add(lblNewLabel);
		
		JPanel panel_dados = new JPanel();
		panel_dados.setBackground(new Color(255, 255, 235));
		panel_dados.setBounds(129, 0, 403, 353);
		panel_dados.setVisible(false);
		contentPane.add(panel_dados);
		panel_dados.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("SEUS DADOS");
		lblNewLabel_5.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(12, 28, 379, 41);
		panel_dados.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nome:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(78, 104, 99, 29);
		panel_dados.add(lblNewLabel_6);
		
		JLabel lblNewLabel_6_1 = new JLabel(usuario.getNome());
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblNewLabel_6_1.setBounds(166, 104, 167, 29);
		panel_dados.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Senha:");
		lblNewLabel_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 19));
		lblNewLabel_6_2.setBounds(78, 163, 99, 29);
		panel_dados.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_6_1_1 = new JLabel(usuario.getSenha());
		lblNewLabel_6_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblNewLabel_6_1_1.setBounds(166, 163, 167, 29);
		panel_dados.add(lblNewLabel_6_1_1);
		
		JLabel lblNewLabel_6_2_1 = new JLabel("Matricula:");
		lblNewLabel_6_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_2_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel_6_2_1.setBounds(78, 217, 99, 29);
		panel_dados.add(lblNewLabel_6_2_1);
		
		JLabel lblNewLabel_6_1_1_1 = new JLabel(""+usuario.getMatricula());
		lblNewLabel_6_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		lblNewLabel_6_1_1_1.setBounds(166, 217, 167, 29);
		panel_dados.add(lblNewLabel_6_1_1_1);
		
		JButton btnNewButton = new JButton("Inicio");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panel_dados.setVisible(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 235));
		btnNewButton.setFocusable(false);
		btnNewButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnNewButton.setBounds(0, 103, 129, 33);
		btnNewButton.setFocusable(false);
		panel_menu.add(btnNewButton);
		
		JButton btnMeusDados = new JButton("Meus Dados");
		btnMeusDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_dados.setVisible(true);
			}
		});
		btnMeusDados.setBorder(null);
		btnMeusDados.setBackground(new Color(255, 255, 235));
		btnMeusDados.setFocusable(false);
		btnMeusDados.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnMeusDados.setBounds(0, 166, 129, 33);
		btnMeusDados.setFocusable(false);
		panel_menu.add(btnMeusDados);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.setBorder(null);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Aplicacao.frame.setVisible(true);
			}
		});
		btnSair.setBackground(new Color(255, 255, 235));
		btnSair.setFocusable(false);
		btnSair.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		btnSair.setBounds(0, 283, 129, 33);
		btnSair.setFocusable(false);
		panel_menu.add(btnSair);
		
		JLabel lblNewLabel_1 = new JLabel("Bem Vindo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(141, 26, 379, 102);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Programa idealizado e desenvolvido");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(141, 128, 379, 49);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("por");
		lblNewLabel_3.setFont(new Font("Segoe UI Black", Font.PLAIN, 18));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(141, 157, 379, 56);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Marco Aur\u00E9lio");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Segoe UI Black", Font.PLAIN, 19));
		lblNewLabel_4.setBounds(141, 209, 379, 34);
		contentPane.add(lblNewLabel_4);
	}
}
