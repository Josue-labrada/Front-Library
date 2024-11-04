
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 *
 * @author josuedominguezlabrada
 */
public class Biblioteca extends JFrame implements ActionListener {
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextArea txtAreaResultado;
    private List<Libro> libros;
    
    public Biblioteca (){
        super("Biblioteca");
        
        libros = new ArrayList<>();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//cerrar y finalizar
        setSize(600,400); //Tamano del cuadro
        setLayout(new BorderLayout());
        setResizable (false); //No permitir redimencionar el tamaño por usuario
        setLocationRelativeTo(null); //Establecer en el centro pantalla
        
        
        //Panel de formulario para agregar libros
        JPanel panelFormulario = new JPanel (new GridLayout(2, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20,20,10,20)); //raro
        
        JLabel lblTitulo = new JLabel("Titulo:");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 17));
        txtTitulo = new JTextField();
        txtTitulo.setFont(new Font("Arial", Font.BOLD, 17));
        
        JLabel lblAutor = new JLabel("Autor:");
        lblAutor.setFont(new Font("Arial", Font.BOLD, 17));
        txtAutor = new JTextField();
        txtAutor.setFont(new Font("Arial", Font.BOLD, 17));
        
        panelFormulario.add(lblTitulo);
        panelFormulario.add(txtTitulo);
        panelFormulario.add(lblAutor);
        panelFormulario.add(txtAutor);
        
        //Botones anadir libro
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(this);
        btnAgregar.setFont(new Font("Arial", Font.BOLD, 15));
        btnAgregar.setBackground(new Color (0, 153, 51));
        btnAgregar.setForeground(Color.WHITE);
        btnAgregar.setPreferredSize (new Dimension(200, 40));
        
        //Boton eliminar
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(this);
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 15));
        btnEliminar.setBackground(new Color (204, 0, 0));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setPreferredSize (new Dimension(200, 40));
        
        //Boton Buscar
        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(this);
        btnBuscar.setFont(new Font("Arial", Font.BOLD, 15));
        btnBuscar.setBackground(new Color (0, 102, 204));
        btnBuscar.setForeground(Color.WHITE);
        btnBuscar.setPreferredSize (new Dimension(200, 40));
    
        //Boton Inventario
        JButton btnInventario = new JButton("Inventario");
        btnInventario.addActionListener(this);
        btnInventario.setFont(new Font("Arial", Font.BOLD, 15));
        btnInventario.setBackground(new Color (255, 153, 0));
        btnInventario.setForeground(Color.WHITE);
        btnInventario.setPreferredSize (new Dimension(200, 40));
    
        //añador los botones
        panelFormulario.add(btnAgregar);
        panelFormulario.add(btnEliminar);
        panelFormulario.add(btnBuscar);
        panelFormulario.add(btnInventario);
        
        //Agregar los resultados
        txtAreaResultado = new JTextArea();
        txtAreaResultado.setEditable(false); //no permitir escribir
        txtAreaResultado.setFont(new Font("Arial", Font.PLAIN, 15));
        txtAreaResultado.setLineWrap(true);
        txtAreaResultado.setWrapStyleWord(true);
        txtAreaResultado.setBackground(new Color(240,240,240));
        txtAreaResultado.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        JScrollPane scrollPane = new JScrollPane(txtAreaResultado);
        scrollPane.setPreferredSize(new Dimension(560, 200));
        
        //Panel general
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelFormulario, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.SOUTH);
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20,20,20, 20));
        
        add(panelPrincipal);
        setVisible(true);
        
        
    
    }
    
    @Override
    public void actionPerformed (ActionEvent e){
        if(e.getActionCommand().equals("Agregar")){
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            if (!titulo.isEmpty() && !autor.isEmpty()){
                agregarLibro(titulo, autor);
                txtTitulo.setText("");
                txtAutor.setText("");
                txtAreaResultado.setText("El libro se ha añadido correctamente :)");
            } else {
                txtAreaResultado.setText("Por favor, introduce el titulo y el autor");
            }
        } else if (e.getActionCommand().equals("Eliminar")){
            String titulo = txtTitulo.getText();
            eliminarLibro(titulo);
            txtTitulo.setText("");
            txtAutor.setText("");
            txtAreaResultado.setText("El libro se elimino de la biblioteca");   
        }else if (e.getActionCommand().equals("Buscar")){
            String terminoBusqueda = txtTitulo.getText();
            String tipoBusqueda = "titulo"; //Buscara por el titulo
            if(!terminoBusqueda.isEmpty()){
                List<String> resultados = buscarLibro(terminoBusqueda, tipoBusqueda);
            }
        }
    }
    
    
}
