package JFrame;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MVC.MVC.ModeloDB;
import MVC.MVC.Vista;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CRUD extends javax.swing.JFrame {

	private JPanel contentPane;
	String codigoPieza;
	String nombrePieza;
	Vista vista;
	ModeloDB modelo = new ModeloDB();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CRUD frame = new CRUD();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CRUD() {
		
		
		
		
		setDefaultCloseOperation(CRUD.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				codigoPieza = JOptionPane.showInputDialog("Codigo de la pieza:");
				nombrePieza = JOptionPane.showInputDialog("Nombre de la pieza:");
				modelo.NuevoProducto(codigoPieza, nombrePieza);
			}
		});
		btnCrear.setBounds(154, 69, 111, 23);
		contentPane.add(btnCrear);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				codigoPieza = JOptionPane.showInputDialog("Codigo de la pieza:");
				modelo.BuscarProducto(codigoPieza);
				
			}
		});
		btnBuscar.setBounds(154, 103, 111, 23);
		contentPane.add(btnBuscar);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				codigoPieza = JOptionPane.showInputDialog("Codigo de la pieza:");
				nombrePieza = JOptionPane.showInputDialog("Nombre de la pieza:");
				modelo.ActualizarProducto(codigoPieza, nombrePieza);
				
				
				
				
			}
		});
		btnNewButton.setBounds(154, 137, 111, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Borrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				codigoPieza = JOptionPane.showInputDialog("Codigo de la pieza:");
				modelo.EliminarProducto(codigoPieza);
				
				
				
			}
		});
		btnNewButton_1.setBounds(154, 171, 111, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salir");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			dispose();
				
			}
		});
		btnNewButton_2.setBounds(154, 205, 111, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("CRUD");
		lblNewLabel.setBounds(198, 29, 46, 14);
		contentPane.add(lblNewLabel);
	}
}
