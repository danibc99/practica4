package tiendecita;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;

public class Tickets extends JFrame {
	static Tickets frame;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContrasena;
	private JTextField textPrecio;
	private JTextField textFecha;
	private JTextField textIdArticulo;
	private JTextField textTicket;

	/**
	 * Launch the application.
	 */
	Connection conexion = null;
	ResultSet rs =null;
	Statement stm =null;
	
	
	private void limpiarCuadrosDeTexto() {
		textTicket.setText("");
		textIdArticulo.setText("");
		textFecha.setText("");
		textPrecio.setText("");
	}	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Tickets();
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
	public Tickets() {
		setTitle("Programa Tiendecita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("TICKETS");
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

			private void setVisible(boolean b) {
	
				
			}
		});
		btnArticulos.setBounds(22, 172, 89, 23);
		contentPane.add(btnArticulos);
		
		JButton btnTickets = new JButton("Tickets");
		btnTickets.setBounds(22, 241, 89, 23);
		contentPane.add(btnTickets);
		
		JButton btnInicio = new JButton("Inicio");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tiendecita a = new Tiendecita();
				a.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnInicio.setBounds(22, 102, 89, 23);
		contentPane.add(btnInicio);
		
		JLabel lblElegirFecha = new JLabel("Elegir Fecha:");
		lblElegirFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblElegirFecha.setBounds(198, 233, 130, 35);
		contentPane.add(lblElegirFecha);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(702, 77, 17, 328);
		contentPane.add(scrollBar);
		
		JLabel lblIdArticulo = new JLabel("Art\u00EDculo:");
		lblIdArticulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblIdArticulo.setBounds(198, 172, 130, 35);
		contentPane.add(lblIdArticulo);
		
		Button buttonAlta = new Button("ALTA");
		buttonAlta.setBackground(new Color(255, 250, 205));
		buttonAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
				  stm = conexion.createStatement();
				stm.executeUpdate("Insert into tickets (idTickets, fechaTickets, facturaTickets, idArticulosFK) values ("+textTicket.getText()+",'"+textFecha.getText()+"',"+textPrecio.getText()+", "+textIdArticulo.getText()+")");
				}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos" + e1);
					
				}
				limpiarCuadrosDeTexto();
				
			}

		});
		buttonAlta.setBounds(269, 370, 95, 35);
		contentPane.add(buttonAlta);
		
		Button buttonConsulta = new Button("CONSULTA");
		buttonConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
				  PreparedStatement preparedStatement = conexion
						  .prepareStatement("Select fechaTickets, facturaTickets, idArticulosFK from tickets where idTickets = ?");
				  preparedStatement.setString(1, textTicket.getText());	
				  ResultSet resultSet = preparedStatement.executeQuery();
				  
				  if (resultSet.next()) {
					  textFecha.setText(resultSet.getString("fechaTickets"));
					  textPrecio.setText(resultSet.getString("facturaTickets"));
					  textIdArticulo.setText(resultSet.getString("idArticulosFK"));
				  } else {
					  JOptionPane.showMessageDialog(null, "ID no encontrada");	  
				  }
				  conexion.close();  
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos" + e1);
			}
			}	
		});
		buttonConsulta.setBackground(new Color(221, 160, 221));
		buttonConsulta.setBounds(456, 370, 95, 35);
		contentPane.add(buttonConsulta);
		
		JLabel lblFlecha = new JLabel("");
		lblFlecha.setIcon(new ImageIcon("C:\\Users\\dani\\Desktop\\Sin t\u00EDtulo-2.png"));
		lblFlecha.setBounds(630, 347, 62, 48);
		contentPane.add(lblFlecha);
		
		JLabel lblHome = new JLabel("");
		lblHome.setIcon(new ImageIcon("C:\\Users\\dani\\Desktop\\Sin t\u00EDtulo-3.png"));
		lblHome.setBounds(22, 8, 63, 52);
		contentPane.add(lblHome);
		
		JLabel lblTotalDelTicket = new JLabel("Total del Ticket:");
		lblTotalDelTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotalDelTicket.setBounds(198, 295, 130, 35);
		contentPane.add(lblTotalDelTicket);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(347, 304, 240, 20);
		contentPane.add(textPrecio);
		
		textFecha = new JTextField();
		textFecha.setColumns(10);
		textFecha.setBounds(347, 242, 240, 20);
		contentPane.add(textFecha);
		
		JLabel lblTicket = new JLabel("N\u00FAmero de Ticket:");
		lblTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTicket.setBounds(198, 106, 153, 35);
		contentPane.add(lblTicket);
		
		textIdArticulo = new JTextField();
		textIdArticulo.setColumns(10);
		textIdArticulo.setBounds(347, 181, 240, 20);
		contentPane.add(textIdArticulo);
		
		textTicket = new JTextField();
		textTicket.setColumns(10);
		textTicket.setBounds(347, 115, 240, 20);
		contentPane.add(textTicket);
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