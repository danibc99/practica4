package tiendecita;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JList;

public class Tiendecita extends JFrame {
	static Tiendecita frame;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContrasena;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Tiendecita();
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
	public Tiendecita() {
		setTitle("Programa Tiendecita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("TIENDECITA");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblTitulo.setBounds(133, 11, 176, 53);
		contentPane.add(lblTitulo);
		
		JButton btnAcceder = new JButton("Acceder");
		btnAcceder.setBounds(620, 11, 86, 23);
		contentPane.add(btnAcceder);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 416, 709, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 64, 709, 2);
		contentPane.add(separator_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(409, 12, 86, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		textContrasena = new JTextField();
		textContrasena.setBounds(515, 12, 86, 20);
		contentPane.add(textContrasena);
		textContrasena.setColumns(10);
		
		JLabel lblContactenos = new JLabel("CONT\u00C1CTENOS");
		lblContactenos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblContactenos.setBounds(22, 429, 166, 35);
		contentPane.add(lblContactenos);
		
		JLabel lblProductos = new JLabel("PRODUCTOS");
		lblProductos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblProductos.setBounds(198, 432, 166, 28);
		contentPane.add(lblProductos);
		
		JLabel lblNuestraEmpresa = new JLabel("NUESTRA EMPRESA");
		lblNuestraEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNuestraEmpresa.setBounds(347, 422, 204, 48);
		contentPane.add(lblNuestraEmpresa);
		
		JLabel lblSuCuenta = new JLabel("SU CUENTA");
		lblSuCuenta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSuCuenta.setBounds(553, 422, 166, 48);
		contentPane.add(lblSuCuenta);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(150, 77, 2, 328);
		contentPane.add(separator_2);
		
		JButton btnArticulos = new JButton("Articulos");
		btnArticulos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Articulo a = new Articulo();
				a.setVisible(true);
				frame.setVisible(false);
			}

		});
		btnArticulos.setBounds(22, 172, 89, 23);
		contentPane.add(btnArticulos);
		
		JButton btnTickets = new JButton("Tickets");
		btnTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tickets b = new Tickets();
				b.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnTickets.setBounds(22, 241, 89, 23);
		contentPane.add(btnTickets);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInicio.setBounds(22, 102, 89, 23);
		contentPane.add(btnInicio);
		
		JLabel lblBienvenido = new JLabel("BIENVENIDO A LA PANTALLA DE INICIO");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblBienvenido.setBounds(187, 118, 532, 175);
		contentPane.add(lblBienvenido);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\dani\\Desktop\\Sin t\u00EDtulo-2.png"));
		lblNewLabel.setBounds(630, 357, 62, 48);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dani\\Desktop\\Sin t\u00EDtulo-3.png"));
		lblNewLabel_1.setBounds(22, 8, 63, 52);
		contentPane.add(lblNewLabel_1);
	}


	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
