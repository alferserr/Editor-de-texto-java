package fernandez.alejandro.editor;

import javax.swing.*;
import java.awt.event.*;
public class Main {
    public static void main(String[] args) {
        Marco marco = new Marco( );
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
    }
     static class Marco extends JFrame {
        public Marco(){
            setBounds(300,300,300,300);
            setTitle("Editor de texto");

            add(new Panel());

        }
    }

    static class Panel extends JPanel{
        public Panel(){
            //------------------ Menu -----------------------------
            JPanel panelMenu = new JPanel();
            menu = new JMenuBar();
            archivo = new JMenu("Archivo");
            editar = new JMenu("Editar");
            selección = new JMenu("Selección");
            ver = new JMenu("Ver");
            apariencia = new JMenu("Apariencia");

            menu.add(archivo);
            menu.add(editar);
            menu.add(selección);
            menu.add(ver);


            //---------------------------- Elementos del menu archivo ----------------------------
            creaItem("Nuevo archivo","archivo","nuevo");
            creaItem("Abrir archivo","archivo", "abrir");
            creaItem("Guardar","archivo","guardar");
            creaItem("Guardar Como","archivo","guardarComo");
            //------------------------------------------------------------------------------------------

            //----------------------------- Elementos del menu editar -----------------------------
            creaItem("Deshacer","editar","");
            creaItem("Rehacer","editar","");
            creaItem("Cortar","editar","");
            creaItem("Copiar","editar","");
            creaItem("Pegar","editar","");
            //------------------------------------------------------------------------------------------

            //----------------------------- Elementos del menu selección --------------------------
            creaItem("Seleccionar todo","selección","");
            //-------------------------------------------------------------------------------------------

            //----------------------------- Elementos del menu ver ---------------------------------
            creaItem("Numeración","ver","");
            ver.add(apariencia);
            creaItem("Normal","apariencia","");
            creaItem("Dark","apariencia","");
            //--------------------------------------------------------------------------------------------

            panelMenu.add(menu);


            //------------------ Area de texto ---------------------
            tPane = new JTabbedPane();
            //--------------------------------------------------------


            add(panelMenu);
            add(tPane);

        }

        public void creaItem(String rotulo, String menu, String accion){
            elementoItem = new JMenuItem(rotulo);

            if (menu.equals("archivo")){
                archivo.add(elementoItem);
                if (accion.equals("nuevo")){
                    elementoItem.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            creaPanel();
                        }
                    });


                }
            } else if (menu.equals("editar")) {
                editar.add(elementoItem);
            } else if (menu.equals("selección")) {
                selección.add(elementoItem);
            }else if (menu.equals("ver")) {
                ver.add(elementoItem);
            }else if (menu.equals("apariencia")) {
                apariencia.add(elementoItem);
            }

        }

        public void creaPanel(){
            ventana = new JPanel();
            areaTexto = new JTextPane();

            ventana.add(areaTexto);

            tPane.addTab("Title",ventana);
        }

        private JTabbedPane tPane;
        private JPanel ventana;
        private JTextPane areaTexto;
        private JMenuBar menu;
        private JMenu archivo, editar, selección, ver, apariencia;
        private JMenuItem elementoItem;
    }
}