package com.hrx.window;

import com.hrx.job.DaTuJob;
import lombok.SneakyThrows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author hrx
 */
public class LoginListener implements ActionListener {

    private javax.swing.JTextField text_code;

    private javax.swing.JPasswordField text_ver;

    private javax.swing.JFrame login;

    public LoginListener(javax.swing.JFrame login,javax.swing.JTextField text_code,javax.swing.JPasswordField text_ver) {
        this.login = login;
        this.text_code = text_code;
        this.text_ver = text_ver;
    }

    @SneakyThrows
    @Override
    public void actionPerformed(ActionEvent e)
    {
        //用户名和密码
        DaTuJob.execute(text_code.getText(), text_ver.getText());
    }
}