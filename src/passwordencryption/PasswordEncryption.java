/*
 * Application pour encrypter des mots de passe, dans le but de les stocker dans une base de données.
 * Évidemment, ceci n'est pas sécuritaire.
 * Don't try this at home, kids!
 */
package passwordencryption;

import Classes.Encrypt;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author Benjamin Alexander
 */
public class PasswordEncryption {

    public static void main(String[] args) {
       Encrypt encrypt=new Encrypt();
        OUTER:
        while (true) {
            try {
                int choix=Integer.valueOf(JOptionPane.showInputDialog(null,
                        "1:Hasher un mot de passe\n"+
                        "2:Comparer un mot de passe brut et un hash\n"+
                        "0:Fin\n"+
                        "Choisir une option"));
                switch (choix) {
                    case 0:
                        break OUTER;
                    case 1:
                        String password = String.valueOf(JOptionPane.showInputDialog(null,"Entrez le mot de passe que vous souhaitez hasher :"));
                        String passwordHash = encrypt.EncryptPassword(password);
                        System.out.printf(passwordHash + "\n");
                        break;
                    case 2:
                        String mdpBrut = String.valueOf(JOptionPane.showInputDialog(null,"Entrez le mot de passe brut"));
                        String hash = String.valueOf(JOptionPane.showInputDialog(null,"Entrez le hash"));
                        System.out.print(encrypt.Compare(hash, mdpBrut) + "\n");
                        break;
                    default: 
                        JOptionPane.showMessageDialog(null,"Mauvais choix.");
                        break;
                }
            }catch(HeadlessException | NumberFormatException ex ){
                JOptionPane.showMessageDialog(null,"Le choix doit être numérique.");
            }
        }
    }   
}
