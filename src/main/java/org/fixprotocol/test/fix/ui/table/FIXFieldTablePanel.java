package org.fixprotocol.test.fix.ui.table;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.fixprotocol.test.fix.FIXField;


public class FIXFieldTablePanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private static final String[] COL_NAMES = new String[] { "Name", "Tag", "Value" };

    private FIXFieldTable jTable;

    public FIXFieldTablePanel() {
        initUI();
    }

    private void initUI() {
        FIXFieldTableModel model = new FIXFieldTableModel();
        FIXTagEditorModel tagEditorModel = new FIXTagEditorModel();

        jTable = new FIXFieldTable(model, tagEditorModel);
        jTable.setAutoscrolls(false);
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
        jTable.setFont(new Font("Consolas", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(jTable);
        this.setLayout(new BorderLayout());
        this.add(scrollPane);
    }

    public void setData(List<FIXField> fixFields) {
        FIXFieldTableModel model = (FIXFieldTableModel) jTable.getModel();
        model.update(fixFields);
    }

    public void setModel(TableModel dataModel) {
        if (dataModel instanceof FIXFieldTableModel) {
            jTable.setModel(dataModel);
        } else {
            throw new IllegalArgumentException("TableModel not of type FIXFieldTableModel");
        }
    }

}
