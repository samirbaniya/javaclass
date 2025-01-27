package javaPractical;


	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class Q9billing extends JFrame {

	    private JTable itemTable;
	    private DefaultTableModel tableModel;
	    private JTextField itemNameField, quantityField, priceField, discountField, totalField;
	    private JTextArea receiptArea;

	    public Q9billing() {
	        setTitle("Billing System");
	        setSize(800, 600);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        // Top Panel for adding items
	        JPanel topPanel = new JPanel(new GridLayout(2, 4, 10, 10));
	        topPanel.setBorder(BorderFactory.createTitledBorder("Add Item"));

	        itemNameField = new JTextField();
	        quantityField = new JTextField();
	        priceField = new JTextField();
	        JButton addButton = new JButton("Add Item");

	        topPanel.add(new JLabel("Item Name:"));
	        topPanel.add(itemNameField);
	        topPanel.add(new JLabel("Quantity:"));
	        topPanel.add(quantityField);
	        topPanel.add(new JLabel("Price:"));
	        topPanel.add(priceField);
	        topPanel.add(addButton);

	        add(topPanel, BorderLayout.NORTH);

	        // Table for displaying items
	        tableModel = new DefaultTableModel(new String[]{"Item Name", "Quantity", "Price", "Total"}, 0);
	        itemTable = new JTable(tableModel);
	        add(new JScrollPane(itemTable), BorderLayout.CENTER);

	        // Bottom Panel for calculating total and generating receipt
	        JPanel bottomPanel = new JPanel(new GridLayout(2, 3, 10, 10));
	        bottomPanel.setBorder(BorderFactory.createTitledBorder("Billing Details"));

	        discountField = new JTextField();
	        totalField = new JTextField();
	        totalField.setEditable(false);

	        JButton calculateButton = new JButton("Calculate Total");
	        JButton generateReceiptButton = new JButton("Generate Receipt");

	        bottomPanel.add(new JLabel("Discount (%):"));
	        bottomPanel.add(discountField);
	        bottomPanel.add(calculateButton);
	        bottomPanel.add(new JLabel("Total Amount:"));
	        bottomPanel.add(totalField);
	        bottomPanel.add(generateReceiptButton);

	        add(bottomPanel, BorderLayout.SOUTH);

	        // Receipt area
	        receiptArea = new JTextArea();
	        receiptArea.setEditable(false);
	        add(new JScrollPane(receiptArea), BorderLayout.EAST);

	        // Add button action
	        addButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                addItem();
	            }
	        });

	        // Calculate total button action
	        calculateButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                calculateTotal();
	            }
	        });

	        // Generate receipt button action
	        generateReceiptButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                generateReceipt();
	            }
	        });

	        setVisible(true);
	    }

	    private void addItem() {
	        String itemName = itemNameField.getText();
	        int quantity;
	        double price;

	        try {
	            quantity = Integer.parseInt(quantityField.getText());
	            price = Double.parseDouble(priceField.getText());

	            double total = quantity * price;
	            tableModel.addRow(new Object[]{itemName, quantity, price, total});

	            itemNameField.setText("");
	            quantityField.setText("");
	            priceField.setText("");
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(this, "Please enter valid quantity and price.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    private void calculateTotal() {
	        double total = 0;

	        for (int i = 0; i < tableModel.getRowCount(); i++) {
	            total += (double) tableModel.getValueAt(i, 3);
	        }

	        try {
	            double discount = Double.parseDouble(discountField.getText());
	            total -= total * (discount / 100);
	        } catch (NumberFormatException e) {
	            // Ignore if no discount is applied
	        }

	        totalField.setText(String.format("%.2f", total));
	    }

	    private void generateReceipt() {
	        StringBuilder receipt = new StringBuilder("===== Receipt =====\n");
	        receipt.append("Item Name\tQuantity\tPrice\tTotal\n");

	        for (int i = 0; i < tableModel.getRowCount(); i++) {
	            String itemName = (String) tableModel.getValueAt(i, 0);
	            int quantity = (int) tableModel.getValueAt(i, 1);
	            double price = (double) tableModel.getValueAt(i, 2);
	            double total = (double) tableModel.getValueAt(i, 3);

	            receipt.append(String.format("%s\t%d\t%.2f\t%.2f\n", itemName, quantity, price, total));
	        }

	        receipt.append("\nTotal Amount: ").append(totalField.getText()).append("\n");
	        receiptArea.setText(receipt.toString());
	    }

	    public static void main(String[] args) {
	        new Q9billing();
	    }
	}
