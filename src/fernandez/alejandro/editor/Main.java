package fernandez.alejandro.editor;

import javax.swing.*;

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

            //------------------ Area de texto ---------------------
            tPane = new JTabbedPane();
            //--------------------------------------------------------

            creaPanel();
            add(tPane);

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
    }
}