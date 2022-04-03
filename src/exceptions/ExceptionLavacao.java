/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author raqueldarellimichelon
 */
public class ExceptionLavacao extends Exception {

    /**
     * Creates a new instance of <code>ExceptionLavacao</code> without detail
     * message.
     */
    public ExceptionLavacao() {
    }

    /**
     * Constructs an instance of <code>ExceptionLavacao</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionLavacao(String msg) {
        super(msg);
    }
}
