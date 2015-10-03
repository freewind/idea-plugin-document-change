package freewind;

import com.intellij.openapi.editor.event.DocumentAdapter;
import com.intellij.openapi.editor.event.DocumentEvent;

public class MyDocumentListener extends DocumentAdapter {

    @Override
    public void documentChanged(DocumentEvent e) {
        System.out.println("### " + Thread.currentThread().getName() + ", document changed: " + e);
    }

}
