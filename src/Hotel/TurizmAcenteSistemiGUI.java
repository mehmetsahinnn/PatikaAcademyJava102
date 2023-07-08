package Hotel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.List;
import java.sql.Connection;

public class TurizmAcenteSistemiGUI extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost/turizm_acente";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "password";

    private JTextField otelAdiTextField;
    private JTextField adresTextField;
    private JTextField epostaTextField;
    private JTextField telefonTextField;
    private JComboBox<String> yildizComboBox;
    private JList<String> tesisOzellikleriList;
    private JList<String> pansiyonTipleriList;
    private DefaultListModel<String> tesisOzellikleriModel;
    private DefaultListModel<String> pansiyonTipleriModel;

    private JTextField donemBaslangicTextField;
    private JTextField donemBitisTextField;
    private JTextField odaAdiTextField;
    private JTextField yatakSayisiTextField;
    private JCheckBox televizyonCheckBox;
    private JCheckBox minibarCheckBox;
    private JCheckBox oyunKonsoluCheckBox;
    private JTextField metrekareTextField;
    private JTextField fiyatTextField;

    private JTextField aramaBolgeTextField;
    private JTextField aramaBaslangicTextField;
    private JTextField aramaBitisTextField;
    private JTextField aramaYetiskinTextField;
    private JTextField aramaCocukTextField;
    private JButton aramaButton;
    private JTable sonucTable;
    private DefaultTableModel sonucTableModel;

    private JTextField rezervasyonOtelTextField;
    private JTextField rezervasyonOdaTextField;
    private JTextField rezervasyonAdTextField;
    private JTextField rezervasyonTcTextField;
    private JButton rezervasyonTamamlaButton;

    public TurizmAcenteSistemiGUI() {
        setTitle("Turizm Acente Sistemi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel otelAdiLabel = new JLabel("Otel Adı:");
        otelAdiTextField = new JTextField();
        JLabel adresLabel = new JLabel("Adres:");
        adresTextField = new JTextField();
        JLabel epostaLabel = new JLabel("E-posta:");
        epostaTextField = new JTextField();
        JLabel telefonLabel = new JLabel("Telefon:");
        telefonTextField = new JTextField();
        JLabel yildizLabel = new JLabel("Yıldız:");
        String[] yildizOptions = {"1", "2", "3", "4", "5"};
        yildizComboBox = new JComboBox<>(yildizOptions);
        JLabel tesisOzellikleriLabel = new JLabel("Tesis Özellikleri:");
        tesisOzellikleriModel = new DefaultListModel<>();
        tesisOzellikleriList = new JList<>(tesisOzellikleriModel);
        tesisOzellikleriList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane tesisOzellikleriScrollPane = new JScrollPane(tesisOzellikleriList);
        JLabel pansiyonTipleriLabel = new JLabel("Pansiyon Tipleri:");
        pansiyonTipleriModel = new DefaultListModel<>();
        pansiyonTipleriList = new JList<>(pansiyonTipleriModel);
        pansiyonTipleriList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane pansiyonTipleriScrollPane = new JScrollPane(pansiyonTipleriList);

        panel.add(otelAdiLabel);
        panel.add(otelAdiTextField);
        panel.add(adresLabel);
        panel.add(adresTextField);
        panel.add(epostaLabel);
        panel.add(epostaTextField);
        panel.add(telefonLabel);
        panel.add(telefonTextField);
        panel.add(yildizLabel);
        panel.add(yildizComboBox);
        panel.add(tesisOzellikleriLabel);
        panel.add(tesisOzellikleriScrollPane);
        panel.add(pansiyonTipleriLabel);
        panel.add(pansiyonTipleriScrollPane);

        JButton otelEkleButton = new JButton("Otel Ekle");
        otelEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String otelAdi = otelAdiTextField.getText();
                String adres = adresTextField.getText();
                String eposta = epostaTextField.getText();
                String telefon = telefonTextField.getText();
                String yildiz = (String) yildizComboBox.getSelectedItem();
                List<String> tesisOzellikleri = tesisOzellikleriList.getSelectedValuesList();
                List<String> pansiyonTipleri = pansiyonTipleriList.getSelectedValuesList();

                try {
                    Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                    String sql = "INSERT INTO oteller (otel_adi, adres, eposta, telefon, yildiz) VALUES (?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                    statement.setString(1, otelAdi);
                    statement.setString(2, adres);
                    statement.setString(3, eposta);
                    statement.setString(4, telefon);
                    statement.setString(5, yildiz);

                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        ResultSet generatedKeys = statement.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            int otelId = generatedKeys.getInt(1);
                            insertTesisOzellikleri(connection, otelId, tesisOzellikleri);
                            insertPansiyonTipleri(connection, otelId, pansiyonTipleri);
                            JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Otel eklendi!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Otel eklenirken bir hata oluştu!");
                    }

                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Veritabanına bağlanırken bir hata oluştu!");
                }
            }
        });


        panel.add(otelEkleButton);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel donemPanel = new JPanel();
        donemPanel.setLayout(new GridLayout(3, 2));

        JLabel donemBaslangicLabel = new JLabel("Başlangıç Tarihi (GG/AA/YYYY):");
        donemBaslangicTextField = new JTextField();
        JLabel donemBitisLabel = new JLabel("Bitiş Tarihi (GG/AA/YYYY):");
        donemBitisTextField = new JTextField();

        donemPanel.add(donemBaslangicLabel);
        donemPanel.add(donemBaslangicTextField);
        donemPanel.add(donemBitisLabel);
        donemPanel.add(donemBitisTextField);

        JButton donemEkleButton = new JButton("Dönem Ekle");
        donemEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String baslangicTarihi = donemBaslangicTextField.getText();
                String bitisTarihi = donemBitisTextField.getText();

                try {
                    Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                    String sql = "INSERT INTO donemler (baslangic_tarihi, bitis_tarihi) VALUES (?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, baslangicTarihi);
                    statement.setString(2, bitisTarihi);

                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Dönem eklendi!");
                    } else {
                        JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Dönem eklenirken bir hata oluştu!");
                    }

                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Veritabanına bağlanırken bir hata oluştu!");
                }
            }
        });

        donemPanel.add(donemEkleButton);

        tabbedPane.addTab("Dönem Yönetimi", donemPanel);

        JPanel odaPanel = new JPanel();
        odaPanel.setLayout(new GridLayout(5, 2));

        JLabel odaAdiLabel = new JLabel("Oda Adı:");
        odaAdiTextField = new JTextField();
        JLabel yatakSayisiLabel = new JLabel("Yatak Sayısı:");
        yatakSayisiTextField = new JTextField();
        JLabel televizyonLabel = new JLabel("Televizyon (Var/Yok):");
        televizyonCheckBox = new JCheckBox();
        JLabel minibarLabel = new JLabel("Minibar (Var/Yok):");
        minibarCheckBox = new JCheckBox();
        JLabel oyunKonsoluLabel = new JLabel("Oyun Konsolu (Var/Yok):");
        oyunKonsoluCheckBox = new JCheckBox();
        JLabel metrekareLabel = new JLabel("Metrekare:");
        metrekareTextField = new JTextField();

        odaPanel.add(odaAdiLabel);
        odaPanel.add(odaAdiTextField);
        odaPanel.add(yatakSayisiLabel);
        odaPanel.add(yatakSayisiTextField);
        odaPanel.add(televizyonLabel);
        odaPanel.add(televizyonCheckBox);
        odaPanel.add(minibarLabel);
        odaPanel.add(minibarCheckBox);
        odaPanel.add(oyunKonsoluLabel);
        odaPanel.add(oyunKonsoluCheckBox);
        odaPanel.add(metrekareLabel);
        odaPanel.add(metrekareTextField);

        JButton odaEkleButton = new JButton("Oda Ekle");
        odaEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String odaAdi = odaAdiTextField.getText();
                int yatakSayisi = Integer.parseInt(yatakSayisiTextField.getText());
                boolean televizyon = televizyonCheckBox.isSelected();
                boolean minibar = minibarCheckBox.isSelected();
                boolean oyunKonsolu = oyunKonsoluCheckBox.isSelected();
                int metrekare = Integer.parseInt(metrekareTextField.getText());

                try {
                    Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                    String sql = "INSERT INTO odalar (oda_adi, yatak_sayisi, televizyon, minibar, oyun_konsolu, metrekare) VALUES (?, ?, ?, ?, ?, ?)";
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, odaAdi);
                    statement.setInt(2, yatakSayisi);
                    statement.setBoolean(3, televizyon);
                    statement.setBoolean(4, minibar);
                    statement.setBoolean(5, oyunKonsolu);
                    statement.setInt(6, metrekare);

                    int rowsAffected = statement.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Oda eklendi!");
                    } else {
                        JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Oda eklenirken bir hata oluştu!");
                    }

                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Veritabanına bağlanırken bir hata oluştu!");
                }
            }
        });

        odaPanel.add(odaEkleButton);

        tabbedPane.addTab("Oda Yönetimi", odaPanel);

        JPanel aramaPanel = new JPanel();
        aramaPanel.setLayout(new GridLayout(6, 2));

        JLabel aramaBolgeLabel = new JLabel("Bölge:");
        aramaBolgeTextField = new JTextField();
        JLabel aramaBaslangicLabel = new JLabel("Giriş Tarihi (GG/AA/YYYY):");
        aramaBaslangicTextField = new JTextField();
        JLabel aramaBitisLabel = new JLabel("Çıkış Tarihi (GG/AA/YYYY):");
        aramaBitisTextField = new JTextField();
        JLabel aramaYetiskinLabel = new JLabel("Yetişkin Sayısı:");
        aramaYetiskinTextField = new JTextField();
        JLabel aramaCocukLabel = new JLabel("Çocuk Sayısı:");
        aramaCocukTextField = new JTextField();

        aramaPanel.add(aramaBolgeLabel);
        aramaPanel.add(aramaBolgeTextField);
        aramaPanel.add(aramaBaslangicLabel);
        aramaPanel.add(aramaBaslangicTextField);
        aramaPanel.add(aramaBitisLabel);
        aramaPanel.add(aramaBitisTextField);
        aramaPanel.add(aramaYetiskinLabel);
        aramaPanel.add(aramaYetiskinTextField);
        aramaPanel.add(aramaCocukLabel);
        aramaPanel.add(aramaCocukTextField);

        aramaButton = new JButton("Ara");
        aramaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bolge = aramaBolgeTextField.getText();
                String baslangicTarihi = aramaBaslangicTextField.getText();
                String bitisTarihi = aramaBitisTextField.getText();
                int yetiskinSayisi = Integer.parseInt(aramaYetiskinTextField.getText());
                int cocukSayisi = Integer.parseInt(aramaCocukTextField.getText());

                try {
                    Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                    String sql = "SELECT o.otel_adi, od.oda_adi, f.fiyat FROM oteller o " +
                            "INNER JOIN odalar od ON o.otel_id = od.otel_id " +
                            "INNER JOIN fiyatlar f ON od.oda_id = f.oda_id " +
                            "INNER JOIN donemler d ON f.donem_id = d.donem_id " +
                            "WHERE o.bolge = ? AND d.baslangic_tarihi <= ? AND d.bitis_tarihi >= ? " +
                            "AND f.yetiskin_sayisi = ? AND f.cocuk_sayisi = ? AND od.stok > 0";

                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, bolge);
                    statement.setString(2, baslangicTarihi);
                    statement.setString(3, bitisTarihi);
                    statement.setInt(4, yetiskinSayisi);
                    statement.setInt(5, cocukSayisi);

                    ResultSet resultSet = statement.executeQuery();

                    sonucTableModel.setRowCount(0);

                    while (resultSet.next()) {
                        String otelAdi = resultSet.getString("otel_adi");
                        String odaAdi = resultSet.getString("oda_adi");
                        double fiyat = resultSet.getDouble("fiyat");

                        sonucTableModel.addRow(new Object[]{otelAdi, odaAdi, fiyat});
                    }

                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Veritabanına bağlanırken bir hata oluştu!");
                }
            }
        });

        aramaPanel.add(aramaButton);

        String[] columnNames = {"Otel Adı", "Oda Adı", "Fiyat"};
        sonucTableModel = new DefaultTableModel(columnNames, 0);
        sonucTable = new JTable(sonucTableModel);
        JScrollPane sonucScrollPane = new JScrollPane(sonucTable);

        aramaPanel.add(sonucScrollPane);

        tabbedPane.addTab("Oda Arama ve Rezervasyon", aramaPanel);

        JPanel rezervasyonPanel = new JPanel();
        rezervasyonPanel.setLayout(new GridLayout(3, 2));

        JLabel rezervasyonOtelLabel = new JLabel("Otel Adı:");
        rezervasyonOtelTextField = new JTextField();
        JLabel rezervasyonOdaLabel = new JLabel("Oda Adı:");
        rezervasyonOdaTextField = new JTextField();
        JLabel rezervasyonAdLabel = new JLabel("Misafir Adı:");
        rezervasyonAdTextField = new JTextField();
        JLabel rezervasyonTcLabel = new JLabel("T.C. Kimlik No:");
        rezervasyonTcTextField = new JTextField();

        rezervasyonPanel.add(rezervasyonOtelLabel);
        rezervasyonPanel.add(rezervasyonOtelTextField);
        rezervasyonPanel.add(rezervasyonOdaLabel);
        rezervasyonPanel.add(rezervasyonOdaTextField);
        rezervasyonPanel.add(rezervasyonAdLabel);
        rezervasyonPanel.add(rezervasyonAdTextField);
        rezervasyonPanel.add(rezervasyonTcLabel);
        rezervasyonPanel.add(rezervasyonTcTextField);

        rezervasyonTamamlaButton = new JButton("Rezervasyon Tamamla");
        rezervasyonTamamlaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String otelAdi = rezervasyonOtelTextField.getText();
                String odaAdi = rezervasyonOdaTextField.getText();
                String misafirAdi = rezervasyonAdTextField.getText();
                String tcKimlikNo = rezervasyonTcTextField.getText();

                try {
                    Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

                    // Odaların stok sayısını güncelle
                    String sql = "UPDATE odalar od INNER JOIN oteller o ON od.otel_id = o.otel_id " +
                            "SET od.stok = od.stok - 1 " +
                            "WHERE o.otel_adi = ? AND od.oda_adi = ? AND od.stok > 0";

                    PreparedStatement updateStatement = connection.prepareStatement(sql);
                    updateStatement.setString(1, otelAdi);
                    updateStatement.setString(2, odaAdi);
                    int rowsAffected = updateStatement.executeUpdate();
                    updateStatement.close();

                    if (rowsAffected > 0) {
                        // Rezervasyonu sisteme kaydet
                        String rezervasyonSql = "INSERT INTO rezervasyonlar (otel_adi, oda_adi, misafir_adi, tc_kimlik_no) " +
                                "VALUES (?, ?, ?, ?)";

                        PreparedStatement insertStatement = connection.prepareStatement(rezervasyonSql);
                        insertStatement.setString(1, otelAdi);
                        insertStatement.setString(2, odaAdi);
                        insertStatement.setString(3, misafirAdi);
                        insertStatement.setString(4, tcKimlikNo);
                        int rowsInserted = insertStatement.executeUpdate();
                        insertStatement.close();

                        if (rowsInserted > 0) {
                            String rezervasyonBilgileri = "Misafir Adı: " + misafirAdi + "\nT.C. Kimlik No: " + tcKimlikNo +
                                    "\nRezervasyon Tamamlandı!\n\nOtel: " + otelAdi + "\nOda: " + odaAdi;

                            JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, rezervasyonBilgileri);
                        } else {
                            JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Rezervasyon tamamlanamadı! Lütfen tekrar deneyin.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Seçilen otel ve oda için rezervasyon yapılamıyor!");
                    }

                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(TurizmAcenteSistemiGUI.this, "Veritabanına bağlanırken bir hata oluştu!");
                }
            }
        });
    }

    private void insertTesisOzellikleri(Connection connection, int otelId, List<String> tesisOzellikleri) throws SQLException {
        String sql = "INSERT INTO otel_tesis (otel_id, tesis_adi) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        for (String tesis : tesisOzellikleri) {
            statement.setInt(1, otelId);
            statement.setString(2, tesis);
            statement.executeUpdate();
        }

        statement.close();
    }

    private void insertPansiyonTipleri(Connection connection, int otelId, List<String> pansiyonTipleri) throws SQLException {
        String sql = "INSERT INTO otel_pansiyon (otel_id, pansiyon_tipi) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        for (String pansiyon : pansiyonTipleri) {
            statement.setInt(1, otelId);
            statement.setString(2, pansiyon);
            statement.executeUpdate();
        }

        statement.close();
    }
}
