package freewind;

import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.fileEditor.FileEditorManagerEvent;
import com.intellij.openapi.fileEditor.FileEditorManagerListener;
import com.intellij.openapi.fileEditor.TextEditor;
import com.intellij.openapi.vfs.VirtualFile;

public class MyFileEditorManagerListener implements FileEditorManagerListener {

    @Override
    public void fileOpened(FileEditorManager source, VirtualFile file) {

    }

    @Override
    public void fileClosed(FileEditorManager source, VirtualFile file) {

    }

    @Override
    public void selectionChanged(FileEditorManagerEvent event) {
        ((TextEditor) event.getNewEditor()).getEditor().getDocument().addDocumentListener(new MyDocumentListener());
    }

}
