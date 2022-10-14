package JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MVC.MVC.ModeloDB;
import MVC.MVC.Vista;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	Vista vista;
	ModeloDB modelo = new ModeloDB();
	CRUD crud = new CRUD();
	boolean crudVisible = false;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		//crear tabla
		
		JButton btnInstanciarTabla = new JButton("Instanciar Tabla");
		btnInstanciarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				modelo.InstanciarTabla();
				
			}
		});
		btnInstanciarTabla.setBounds(152, 92, 127, 23);
		contentPane.add(btnInstanciarTabla);
		
		
		//...............
		//borrar
		
		
		JButton btnBorrarTabla = new JButton("Borrar Tabla");
		btnBorrarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				modelo.BorrarTabla();
				
			}
		});
		
		
		
		
		btnBorrarTabla.setBounds(152, 126, 127, 23);
		contentPane.add(btnBorrarTabla);
		
		
		
		//...........................................
		
		
		
		
		JButton btnCRUD = new JButton("CRUD");
		btnCRUD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
			crud.setVisible(true);
			crudVisible = true;					
			}
		});
		btnCRUD.setBounds(152, 160, 127, 23);
		contentPane.add(btnCRUD);
		
		
		
		
		// Salir
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				
				if (crudVisible = true) {
					crud.dispose();
				}
			}
		});
		btnSalir.setBounds(152, 194, 127, 23);
		contentPane.add(btnSalir);
		
		
		//..........
		
		JLabel lblNewLabel = new JLabel("--- Menú ---");
		lblNewLabel.setBounds(192, 45, 63, 36);
		contentPane.add(lblNewLabel);
	}

}
