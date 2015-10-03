package freewind;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.event.DocumentAdapter;
import com.intellij.openapi.editor.event.DocumentEvent;

public class MyDocumentListener extends DocumentAdapter {

    @Override
    public void documentChanged(final DocumentEvent e) {
        System.out.println("### documentChanged, " + Thread.currentThread().getName() + ", document changed: " + e);
        System.out.println(e.getDocument().getText());

        ApplicationManager.getApplication().invokeLater(new Runnable() {
            @Override
            public void run() {
                ApplicationManager.getApplication().runWriteAction(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("### invokeLater, " + Thread.currentThread().getName());
                        e.getDocument().setText(e.getDocument().getText() + "!!!!!!!!!!!!!!!!!!!!!");
                    }
                });

            }
        });

        slowAction();
    }

    private void slowAction() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
