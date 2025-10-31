<img width="3780" height="1890" alt="FIX" src="https://github.com/user-attachments/assets/a0093b07-8ab2-4597-84f8-85b46372dff8" />


# Bumi Nusantara Project
## 🌱 Sistem Monitoring dan Pengelolaan Fasilitas Hijau

## SDGs: Sustainable Cities and Communities  
## **Fokus Area:** Smart and Environmentally Friendly Urban Planning  

<img width="3780" height="1890" alt="Project Bumi Nusantara (Banner Horizontal) (1)" src="https://github.com/user-attachments/assets/b10df782-3784-44d8-9c93-0bcdf8a4b9d3" />

---

## Deskripsi Singkat Program

Aplikasi **“Sistem Monitoring dan Pengelolaan Fasilitas Hijau”** merupakan program berbasis **Java** yang dikembangkan dengan menerapkan **lima pilar utama Pemrograman Berorientasi Objek (Object-Oriented Programming / OOP)**, yaitu **Encapsulation**, **Inheritance**, **Abstraction**, **Polymorphism**, dan **Interface**.  
Program ini juga terintegrasi dengan **basis data MySQL** melalui **XAMPP**, serta dilengkapi dengan **Graphical User Interface (GUI)** yang dibangun menggunakan **Java Swing** pada **NetBeans IDE**.

Proyek ini dirancang untuk mendukung pencapaian **Tujuan Pembangunan Berkelanjutan (SDGs) ke-11**, yakni *Sustainable Cities and Communities*, dengan fokus pada *Smart and Environmentally Friendly Urban Planning*.  
Melalui sistem ini, pengelolaan berbagai fasilitas hijau seperti **taman kota**, **bank sampah**, dan **Tempat Pembuangan Akhir (TPA)** dapat dilakukan secara lebih efektif, transparan, dan terintegrasi.

Aplikasi ini menyediakan fitur utama berupa **pendataan, pemantauan, dan pelaporan fasilitas hijau**, yang dapat diakses oleh pihak pemerintah maupun masyarakat.  
Seluruh data disimpan dan dikelola secara terpusat melalui basis data, sehingga proses **monitoring dan evaluasi kondisi lingkungan** dapat dilakukan secara efisien serta mendukung pembuatan kebijakan berbasis data (*data-driven policy*).

---

# 🧩 Analisis Penerapan 5 Pilar OOP pada Package `Model`
Proyek **Sistem Monitoring dan Pengelolaan Fasilitas Hijau** dikembangkan menggunakan bahasa pemrograman **Java** dengan paradigma **Object-Oriented Programming (OOP)**.  
Seluruh file dalam package `Model` telah menerapkan kelima pilar utama OOP, yaitu:

> **Encapsulation**, **Inheritance**, **Abstraction**, **Polymorphism**, dan **Interface**.

Berikut penjelasan lengkap disertai potongan kode dan analisis penerapan dari setiap pilar OOP:

---

## 1. Encapsulation (Enkapsulasi)

### Konsep:
Enkapsulasi adalah prinsip OOP untuk melindungi data agar tidak dapat diakses langsung dari luar kelas. <br> Data disembunyikan menggunakan modifier `private` dan hanya bisa diakses melalui method **getter** dan **setter**.

---

### 📁 a. `Fasilitas.java` (Package: `Model`)
```java
private int id_fasilitas;
private String nama_fasilitas;
private String jenis_fasilitas;
private String lokasi;
private String id_kelurahan;

public int getId_fasilitas() { return id_fasilitas; }
public void setId_fasilitas(int id_fasilitas) { this.id_fasilitas = id_fasilitas; }

public String getNama_fasilitas() { return nama_fasilitas; }
public void setNama_fasilitas(String nama_fasilitas) { this.nama_fasilitas = nama_fasilitas; }

public String getJenis_fasilitas() { return jenis_fasilitas; }
public void setJenis_fasilitas(String jenis_fasilitas) { this.jenis_fasilitas = jenis_fasilitas; }
```

Kode ini terdapat pada package `Model`, file `Fasilitas.java`.<br>
Atribut id_fasilitas, nama_fasilitas, dll dijadikan private agar tidak bisa diakses langsung. <br> Akses dan modifikasi dilakukan hanya lewat getter–setter untuk menjaga integritas data.

### 📁 b. `BankSampah.java` (Package: `Model`)
```java
private String nama_pengelola;
private String kontak;
private String jam_operasional;

public String getNama_pengelola() { return nama_pengelola; }
public void setNama_pengelola(String nama_pengelola) { this.nama_pengelola = nama_pengelola; }

public String getKontak() { return kontak; }
public void setKontak(String kontak) { this.kontak = kontak; }

public String getJam_operasional() { return jam_operasional; }
public void setJam_operasional(String jam_operasional) { this.jam_operasional = jam_operasional; }
```

Kode ini berada pada `Model.BankSampah`. <br>
Enkapsulasi melindungi informasi internal bank sampah (seperti pengelola dan kontak).

### 📁 c. `TPA.java`
```java
private String status;
private double kapasitas_maks_ton;

public String getStatus() { return status; }
public void setStatus(String status) { this.status = status; }

public double getKapasitas_maks_ton() { return kapasitas_maks_ton; }
public void setKapasitas_maks_ton(double kapasitas_maks_ton) { this.kapasitas_maks_ton = kapasitas_maks_ton; }
```

Kode ini berada di `Model.TPA`. <br>
Menjaga agar kapasitas dan status tidak dapat dimodifikasi sembarangan tanpa prosedur yang benar.

### 📁 d. `Kelurahan.java`
```java
private String id_kelurahan;
private String nama_kelurahan;
private String lokasi_kelurahan;
private String zona;

public String getId_kelurahan() { return id_kelurahan; }
public void setId_kelurahan(String id_kelurahan) { this.id_kelurahan = id_kelurahan; }
```

Berada pada package `model.Kelurahan`.<br>
Menjaga integritas data kelurahan dan zona lingkungan dari akses langsung.

### 📁 e. `Laporan.java` & `User.java`
```java
private int id_laporan;
private int id_user;
private String email;
private String password;
```

Dua file ini `(model.Laporan & model.User)` menggunakan `enkapsulasi` untuk melindungi data sensitif seperti email, password, dan laporan pengguna.

---

### 2. Inheritance (Pewarisan)

### Konsep:
Mewarisi atribut dan method dari kelas induk agar bisa digunakan ulang oleh kelas turunan.

---

### 📁 a. `BankSampah.java`
```java
public class BankSampah extends Fasilitas {
    public BankSampah(int id_fasilitas, String nama_fasilitas, String jenis_fasilitas,
                      String lokasi, String id_kelurahan,
                      String nama_pengelola, String kontak, String jam_operasional) {
        super(id_fasilitas, nama_fasilitas, jenis_fasilitas, lokasi, id_kelurahan);
        this.nama_pengelola = nama_pengelola;
        this.kontak = kontak;
        this.jam_operasional = jam_operasional;
    }
}
```

Kelas `BankSampah` merupakan kelas turunan dari `Fasilitas`. <br>
Keyword extends menunjukkan pewarisan, dan `super()` digunakan untuk memanggil konstruktor dari kelas induk.<br>
Dengan ini, semua atribut dasar fasilitas otomatis dimiliki oleh BankSampah. 

### 📁 b. `TPA.java`
```java
public class TPA extends Fasilitas {
    public TPA(int id_fasilitas, String nama_fasilitas, String jenis_fasilitas,
               String lokasi, String id_kelurahan, String status, double kapasitas_maks_ton) {
        super(id_fasilitas, nama_fasilitas, jenis_fasilitas, lokasi, id_kelurahan);
        this.status = status;
        this.kapasitas_maks_ton = kapasitas_maks_ton;
    }
}
```

Kelas TPA juga menurunkan sifat dari `Fasilitas`. <br>
Penggunaan `super()` menginisialisasi atribut dasar dari induk. <br>
Menunjukkan praktik pewarisan agar atribut umum tidak perlu dideklarasi ulang.

### 📁 c. `TapakBerkelanjutan.java`
```java
public class TapakBerkelanjutan extends Fasilitas {
    public TapakBerkelanjutan(int id_fasilitas, String nama_fasilitas, String jenis_fasilitas,
                              String lokasi, String id_kelurahan,
                              double luas_lahan, String kondisi) {
        super(id_fasilitas, nama_fasilitas, jenis_fasilitas, lokasi, id_kelurahan);
        this.luas_lahan = luas_lahan;
        this.kondisi = kondisi;
    }
}
```

`TapakBerkelanjutan` mewarisi seluruh atribut umum `fasilitas` seperti `nama_fasilitas`, `lokasi`, dll. <br>
Selain itu, ia menambahkan atribut unik `luas_lahan` dan kondisi yang khusus untuk jenis fasilitas ini.


---

### 3. Abstraction (Abstraksi)

### Konsep:
Abstraksi digunakan untuk menyembunyikan detail kompleks, hanya menampilkan bagian penting kepada pengguna melalui kelas abstrak atau method abstrak.

---

### 📁 a. `Fasilitas.java`
```java
public abstract class Fasilitas implements IFasilitas {
    @Override
    public abstract void tampilkanInfo();
}
```
`Fasilitas` merupakan kelas abstrak yang berfungsi sebagai cetak biru (blueprint). <br>
Method `tampilkanInfo()` dideklarasikan abstrak agar setiap subclass wajib mengimplementasikannya sesuai kebutuhan masing-masing.

### 📁 b. `Laporan.java`
```java
public void tampilkanInfo() {
    System.out.println("Laporan #" + id_laporan);
    System.out.println("Lokasi: " + alamat_lokasi);
    System.out.println("Deskripsi: " + deskripsi);
    System.out.println("Status: " + status);
    System.out.println("Tanggal: " + tanggal_lapor);
}
```
`Abstraksi` di Laporan menyembunyikan atribut internal dan hanya menampilkan data penting kepada pengguna.

### 📁 c. `Kelurahan.java`
```java
public void tampilkanInfo() {
    System.out.println("Kelurahan: " + nama_kelurahan +
                       " | Lokasi: " + lokasi_kelurahan +
                       " | Zona: " + zona);
}
```
Menyediakan representasi ringkas dari data kelurahan tanpa menampilkan seluruh detail internalnya.


---

### 4. Polymorphism (Polimorfisme)

### Konsep:
Polimorfisme memungkinkan method dengan nama yang sama memiliki perilaku berbeda tergantung pada objek yang memanggilnya.

---

### 📁 a. `BankSampah.java`
```java
@Override
public void tampilkanInfo() {
    System.out.println("Bank Sampah: " + getNama_fasilitas());
    System.out.println("Pengelola: " + nama_pengelola + " | Kontak: " + kontak);
}

@Override
public boolean validate() {
    return super.validate() && nama_pengelola != null && !nama_pengelola.isEmpty();
}
```

Method `tampilkanInfo()` dan `validate()` menampilkan perilaku berbeda dari induknya `Fasilitas`, <br> menyesuaikan dengan konteks objek Bank Sampah. 

### 📁 b. `TPA.java`
```java
@Override
public void tampilkanInfo() {
    System.out.println("TPA: " + getNama_fasilitas() +
        " | Kapasitas: " + kapasitas_maks_ton + " ton | Status: " + status);
}

@Override
public boolean validate() {
    return super.validate()
        && kapasitas_maks_ton > 0
        && status != null
        && !status.isEmpty();
}
```

Method yang sama (`tampilkanInfo()` dan `validate()`) dioverride  <br> agar menampilkan perilaku khusus pada TPA yang berbeda dengan kelas lain seperti `BankSampah`.

### 📁 c. `TapakBerkelanjutan.java`
```java
@Override
public void tampilkanInfo() {
    System.out.println("Tapak Berkelanjutan: " + getNama_fasilitas());
    System.out.println("Luas Lahan: " + luas_lahan + " m² | Kondisi: " + kondisi);
}
```
Menampilkan detail `fasilitas tapak berkelanjutan`. <br>
Method `tampilkanInfo()` memiliki perilaku yang unik, meskipun nama method-nya sama dengan kelas lain.

---

### 5. Interface (Antarmuka)
### Konsep:
Interface mendefinisikan kontrak perilaku umum yang wajib diimplementasikan oleh kelas yang menggunakannya.

---

### 📁 a. `IFasilitas.java`
```java
public interface IFasilitas {
    void tampilkanInfo();
    boolean validate();
}
```

Interface `IFasilitas` berfungsi sebagai kontrak standar untuk setiap `fasilitas`. <br>
Semua kelas yang mengimplementasikannya harus memiliki method `tampilkanInfo()` dan `validate()`.

### 📁 b. Implementasi di Fasilitas.java
```java
public abstract class Fasilitas implements IFasilitas {
    @Override
    public abstract void tampilkanInfo();

    @Override
    public boolean validate() {
        return nama_fasilitas != null && !nama_fasilitas.isEmpty()
            && jenis_fasilitas != null && !jenis_fasilitas.isEmpty();
    }
}
```

Kelas `Fasilitas` mengimplementasikan `IFasilitas` untuk mewariskan kontrak perilaku ke semua subclass-nya `(TPA, BankSampah, TapakBerkelanjutan)`.
Dengan cara ini, seluruh jenis fasilitas dipastikan memiliki method `tampilkanInfo() dan validate()`.

---

### 🌍 Sustainability Reflection
Penerapan lima pilar OOP pada package Model berhasil membentuk sistem yang terstruktur, aman, dan mudah dikembangkan. <br> 
Melalui konsep enkapsulasi, pewarisan, abstraksi, polimorfisme, dan interface, sistem ini mampu mengelola data <br> 
fasilitas hijau secara efisien dan konsisten. Desain berbasis objek ini tidak hanya memperkuat arsitektur program, <br> 
tetapi juga mendukung visi proyek dalam menciptakan sistem monitoring dan pengelolaan fasilitas hijau yang cerdas <br> 
dan berkelanjutan, <br> sejalan dengan tujuan SDGs.

---

## Struktur package
1. Koneksi Database
   
   <img width="366" height="39" alt="image" src="https://github.com/user-attachments/assets/326066df-3609-40d0-931f-9261bc9d09fc" />

   Package `KoneksiDB` berfungsi untuk mengatur dan menghubungkan aplikasi dengan database MySQL melalui class `KoneksiDatabase.java`.

2. Model

   <img width="365" height="165" alt="image" src="https://github.com/user-attachments/assets/e451529a-c409-4a2b-96a6-c0a9ee665440" />

   Package `Model` berisi class-class yang merepresentasikan data utama sistem seperti pengguna, fasilitas, laporan, dan entitas terkait pengelolaan lingkungan.

3. Service
   
   <img width="364" height="38" alt="image" src="https://github.com/user-attachments/assets/6a5f698e-f7b1-4447-b02b-6c05301bf2d9" />

   Package Service berisi class yang menangani logika bisnis dan menghubungkan antara data pada model dengan proses dalam aplikasi.

4. bumi_nusantara

   <img width="364" height="38" alt="image" src="https://github.com/user-attachments/assets/71b01d7f-e8f0-442d-a029-93a2d574c1c5" />

   Package `bumi_nusantara` berisi class utama `Bumi_Nusantara.java` yang menjadi titik awal atau entry point dalam menjalankan aplikasi.

5. images

   <img width="363" height="379" alt="image" src="https://github.com/user-attachments/assets/79ac91ba-b9a5-4813-abd7-fe63d69ea2b0" />

   Folder `images` berisi berbagai file gambar yang digunakan sebagai aset visual dalam antarmuka aplikasi seperti ikon, banner, dan elemen desain lainnya.

6. view

   <img width="363" height="250" alt="image" src="https://github.com/user-attachments/assets/ca65526b-4c95-4198-8e94-e5740d1ddcbc" />

   Folder view berisi berbagai file Java yang digunakan untuk menampilkan antarmuka pengguna (UI) seperti login, menu utama, peta, dan pengelolaan data oleh admin maupun user.

7. Libraries

   <img width="365" height="166" alt="Screenshot 2025-10-31 231209" src="https://github.com/user-attachments/assets/ac1a64a8-7a5a-482a-a01e-2f258170a967" />

   Folder Libraries berisi file .jar yang dibutuhkan untuk menjalankan aplikasi, seperti konektor MySQL, tampilan antarmuka (FlatLaf & AbsoluteLayout), pustaka tambahan (commons-logging, jxmapviewer), serta      JDK 24 sebagai lingkungan pengembangan utama.

## Library atau Framework yang digunakan (jika menerapkan nilai tambah)
- Menerapkan MVC pada program
  
   <img width="372" height="231" alt="image" src="https://github.com/user-attachments/assets/40128a3e-ae4b-4acd-aca6-cfee16638174" />

   Struktur folder pada proyek ini sudah menerapkan pola MVC untuk nilai tambah, dengan pembagian package untuk model, view, service (controller), koneksi database, dan aset gambar.

## Cara menggunakan program, sertakan screenshoot GUI.
ini jelasin dulu gimana cara pakenya baru di ss GUI nya
