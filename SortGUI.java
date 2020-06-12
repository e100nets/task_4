package ilya.ignatov;

import  ru.vsu.cs.util.JTableUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SortGUI extends JFrame {
    private JPanel jPanel = new JPanel();
    private JTable initInt = new JTable();
    private JTable initString = new JTable();
    private JTable finalInt = new JTable();
    private JTable finalString = new JTable();
    private JLabel warn = new JLabel("ВНИМАНИЕ! КОЛИЧЕСТВО ЭЛЕМЕНТОВ В ОБОИХ МАССИВАХ ДОЛЖНО БЫТЬ ОДИНАКОВО");
    private JLabel addIntLabel = new JLabel("Добавить в массив целых чисел");
    private JLabel addStringLabel = new JLabel("Добавить в массив с объектами");
    private JLabel intTable = new JLabel("Массив целых чисел");
    private JLabel stringTable = new JLabel("Массив с объектами");
    private JLabel finalArrays = new JLabel("Отсортированные массивы");
    private JTextField valueInt = new JTextField();
    private JTextField valueString = new JTextField();
    private JButton addInt = new JButton("Добавить");
    private JButton addString = new JButton("Добавить");
    private JButton execute = new JButton("Выполнить сортировку");

    public SortGUI() {
        super("Сортировка массивов");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        BubbleSort bubbleSort = new BubbleSort();
        ArrayList <String> intArray = new ArrayList<>();
        ArrayList <String> stringArray = new ArrayList<>();

        addInt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                intArray.add(valueInt.getText());
                String[] array = intArray.toArray(new String[0]);
                JTableUtils.writeArrayToJTable(initInt, array);
                valueInt.setText("");
            }
        });

        addString.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                stringArray.add(valueString.getText());
                String[] array = stringArray.toArray(new String[0]);
                JTableUtils.writeArrayToJTable(initString, array);
                valueString.setText("");
            }
        });

        execute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] orderValues = JTableUtils.readIntArrayFromJTable(initInt);
                    String[] data = JTableUtils.readStringArrayFromJTable(initString);
                    bubbleSort.sort(data, orderValues);
                    JTableUtils.writeArrayToJTable(finalInt, orderValues);
                    JTableUtils.writeArrayToJTable(finalString, data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        jPanel.setLayout(null);
        warn.setBounds(5, 5, 800, 20);
        addIntLabel.setBounds(5, 30, 300, 20);
        valueInt.setBounds(310, 30, 80, 20);
        addInt.setBounds(395, 30, 200, 20);
        addStringLabel.setBounds(5, 55, 300, 20);
        valueString.setBounds(310, 55, 80, 20);
        addString.setBounds(395, 55, 200, 20);
        intTable.setBounds(5, 80, 200, 20);
        initInt.setBounds(210, 80, 100, 20);
        stringTable.setBounds(5, 105, 200, 20);
        initString.setBounds(210, 105, 100, 20);
        execute.setBounds(5, 130, 300, 20);
        finalArrays.setBounds(5, 155, 200, 20);
        finalInt.setBounds(5, 180, 100, 20);
        finalString.setBounds(5, 205, 100, 20);

        jPanel.add(warn);
        jPanel.add(addIntLabel);
        jPanel.add(valueInt);
        jPanel.add(addInt);
        jPanel.add(addStringLabel);
        jPanel.add(valueString);
        jPanel.add(addString);
        jPanel.add(intTable);
        jPanel.add(initInt);
        jPanel.add(stringTable);
        jPanel.add(initString);
        jPanel.add(execute);
        jPanel.add(finalArrays);
        jPanel.add(finalInt);
        jPanel.add(finalString);

        getContentPane().add(jPanel);
    }
    public static void main (String[] args) throws Exception {
        SortGUI app = new SortGUI();
        app.setBounds(100, 100, 800, 300);
        app.setVisible(true);
    }
}
