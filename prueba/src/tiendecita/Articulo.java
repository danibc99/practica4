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

import java.awt.List;
import java.awt.Choice;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JCheckBox;
import javax.swing.border.BevelBorder;
import java.awt.Button;

public class Articulo extends JFrame {
	static Articulo frame;
	private JPanel contentPane;
	private JTextField textUsuario;
	private JTextField textContrasena;
	private JTextField textDescripcion;
	private JTextField textPrecio;
	private JTextField textCantidad;

	/**
	 * Launch the application.
	 */
	
	Connection conexion = null;
	ResultSet rs =null;
	Statement stm =null;
	private JTextField textId;
	
	private void limpiarCuadrosDeTexto() {
		textId.setText("");
		textDescripcion.setText("");
		textPrecio.setText("");
		textCantidad.setText("");
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Articulo();
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
	public Articulo() {
		setTitle("Programa Tiendecita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 527);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("ART\u00CDCULOS");
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
				this.setVisible(false);
			}

			private void setVisible(boolean b) {
	
				
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
				Tiendecita a = new Tiendecita();
				a.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnInicio.setBounds(22, 102, 89, 23);
		contentPane.add(btnInicio);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(702, 76, 17, 329);
		contentPane.add(scrollBar);
		
		Button buttonAlta = new Button("ALTA");
		
		buttonAlta.setBackground(new Color(0, 255, 0));
		buttonAlta.setBounds(239, 366, 70, 22);
		contentPane.add(buttonAlta);
		
		Button buttonConsulta = new Button("CONSULTA");
		buttonConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				conexion = Conexion.conectar();
				try {
				  PreparedStatement preparedStatement = conexion
						  .prepareStatement("Select descripcionArticulos, precioArticulos, cantidadArticulos from articulos where idArticulos = ?");
				  preparedStatement.setString(1, textId.getText());	
				  ResultSet resultSet = preparedStatement.executeQuery();
				  
				  if (resultSet.next()) {
					  textDescripcion.setText(resultSet.getString("descripcionArticulos"));
					  textPrecio.setText(resultSet.getString("precioArticulos"));
					  textCantidad.setText(resultSet.getString("cantidadArticulos"));
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
		buttonConsulta.setBounds(335, 366, 70, 22);
		contentPane.add(buttonConsulta);
		
		Button buttonBaja = new Button("BAJA");
		buttonBaja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
				  PreparedStatement preparedStatement = conexion
						  .prepareStatement("DELETE FROM articulos Where idArticulos = ?");
				  
				  preparedStatement.setString(1, textId.getText());
				  
				  int resultado = preparedStatement.executeUpdate();
				  if (resultado > 0) {
					  JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
					  limpiarCuadrosDeTexto();
					  conexion.close();
				  } else {
					  JOptionPane.showMessageDialog(null, "No se puede eliminar el registro");
				  }
				}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos" + e1);
					
				}
								
			}
		});
		buttonBaja.setBackground(new Color(255, 99, 71));
		buttonBaja.setBounds(427, 366, 70, 22);
		contentPane.add(buttonBaja);
		
		Button buttonModificar = new Button("MODIFICAR");
		buttonModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
				  PreparedStatement preparedStatement = conexion
						  .prepareStatement("UPDATE articulos SET descripcionArticulos = ?, precioArticulos = ?, cantidadArticulos = ? Where idArticulos = ?");
				  
				  preparedStatement.setString(1, textDescripcion.getText());
				  preparedStatement.setString(2, textPrecio.getText());
				  preparedStatement.setString(3, textCantidad.getText());
				  preparedStatement.setString(4, textId.getText());
				  
				  int resultado = preparedStatement.executeUpdate();
				  if (resultado > 0) {
					  JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
					  limpiarCuadrosDeTexto();
					  conexion.close();
				  } else {
					  JOptionPane.showMessageDialog(null, "No se puede modificar el registro");
				  }
				}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos" + e1);
					
				}
				
			}

		});
		buttonModificar.setBackground(new Color(255, 140, 0));
		buttonModificar.setBounds(515, 366, 70, 22);
		contentPane.add(buttonModificar);
		
		JLabel lblFlecha = new JLabel("");
		lblFlecha.setIcon(new ImageIcon("C:\\Users\\dani\\Desktop\\Sin t\u00EDtulo-2.png"));
		lblFlecha.setBounds(630, 357, 62, 48);
		contentPane.add(lblFlecha);
		
		JLabel lblHome = new JLabel("");
		lblHome.setIcon(new ImageIcon("C:\\Users\\dani\\Desktop\\Sin t\u00EDtulo-3.png"));
		lblHome.setBounds(22, 8, 63, 52);
		contentPane.add(lblHome);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescripcion.setBounds(216, 172, 77, 19);
		contentPane.add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrecio.setBounds(216, 239, 48, 23);
		contentPane.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCantidad.setBounds(216, 311, 70, 19);
		contentPane.add(lblCantidad);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(318, 173, 245, 20);
		contentPane.add(textDescripcion);
		textDescripcion.setColumns(10);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(318, 239, 245, 20);
		contentPane.add(textPrecio);
		
		textCantidad = new JTextField();
		textCantidad.setColumns(10);
		textCantidad.setBounds(318, 310, 245, 20);
		contentPane.add(textCantidad);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblId.setBounds(216, 102, 77, 19);
		contentPane.add(lblId);
		
		textId = new JTextField();
		textId.setColumns(10);
		textId.setBounds(318, 103, 245, 20);
		contentPane.add(textId);
		buttonAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conexion = Conexion.conectar();
				try {
				  stm = conexion.createStatement();
				stm.executeUpdate("Insert into articulos (idArticulos, descripcionArticulos, precioArticulos, cantidadArticulos) values ("+textId.getText()+",'"+textDescripcion.getText()+"',"+textPrecio.getText()+", "+textCantidad.getText()+")");
				}
				catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Ocurrio un error con el acceso de la base de datos" + e1);
					
				}
				limpiarCuadrosDeTexto();
				
			}

		});
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