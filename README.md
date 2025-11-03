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

## 🗂️ Struktur package
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

## 📂 Library atau Framework yang digunakan (jika menerapkan nilai tambah)
- Menerapkan MVC pada program
  
   <img width="372" height="231" alt="image" src="https://github.com/user-attachments/assets/40128a3e-ae4b-4acd-aca6-cfee16638174" />

   Struktur folder pada proyek ini sudah menerapkan pola MVC untuk nilai tambah, dengan pembagian package untuk model, view, service (controller), koneksi database, dan aset gambar.

## Cara menggunakan program
Berikut merupakan penjelasan mengenai cara penggunaan program “Sistem Monitoring dan Pengelolaan Fasilitas Hijau”,<br> 
yang menampilkan berbagai tampilan antarmuka (Graphical User Interface) dari aplikasi ini. Setiap tampilan menggambarkan <br> 
fungsi dan peran masing-masing halaman yang telah dirancang untuk mendukung proses monitoring dan pengelolaan <br> 
fasilitas hijau secara digital.

Program ini terdiri dari beberapa Frame dan Panel utama yang terbagi menjadi dua bagian, yaitu:
1. Halaman untuk User (Masyarakat) – berfungsi untuk melakukan login, pengiriman laporan, melihat fasilitas, serta memantau zona hijau wilayahnya.
2. Halaman untuk Admin (Pihak Pengelola) – berfungsi untuk mengelola data fasilitas, memverifikasi laporan, dan melakukan evaluasi wilayah.

Melalui tampilan-tampilan berikut, dapat terlihat bagaimana sistem ini bekerja secara menyeluruh, mulai dari tahap login hingga proses pengelolaan data lingkungan.
Setiap bagian dilengkapi dengan deskripsi dan fungsi masing-masing GUI, agar pengguna maupun pengembang dapat memahami alur penggunaan program dengan lebih mudah dan terstruktur.

<details>
<summary>🌿 Halaman Menu Login (Pemilihan Peran)</summary>
Halaman Menu Login merupakan tampilan pembuka dan merupakan gerbang utama sistem “Sistem Monitoring dan Pengelolaan Fasilitas Hijau”.
Tujuannya adalah untuk mengarahkan pengguna agar memilih peran (role) sebelum melakukan proses login, yaitu User (masyarakat umum) atau Admin (pihak pengelola/pemerintah).

Sistem ini menerapkan dua tingkat akses berbeda, sehingga pemilihan peran sejak awal membantu aplikasi menampilkan halaman login yang sesuai dengan hak akses pengguna.

</details>

<details>
<summary>🌱 Halaman Login User</summary>
Halaman ini merupakan tampilan login khusus bagi pengguna (User/Masyarakat) dalam sistem Sistem Monitoring dan Pengelolaan Fasilitas Hijau.
Pada halaman ini, pengguna dapat melakukan autentikasi menggunakan email dan password sebelum masuk ke dalam sistem.
Tampilan dirancang dengan konsep green interface yang menonjolkan nilai keberlanjutan dan selaras dengan tema utama proyek Bumi Nusantara Project.

</details>

<details>
<summary>🌳 Halaman Login Admin</summary>
Halaman ini merupakan tampilan login khusus bagi Admin atau pihak pengelola sistem dalam aplikasi Sistem Monitoring dan Pengelolaan Fasilitas Hijau.
Pada halaman ini, admin dapat masuk menggunakan akun resmi untuk mengakses fitur pengelolaan data, seperti verifikasi laporan, pembaruan fasilitas hijau, serta evaluasi zona wilayah.
Tampilan dirancang dengan konsep yang seragam dengan halaman login user, menampilkan nuansa hijau alami dan visual pohon besar sebagai simbol pengawasan serta pertumbuhan berkelanjutan.

</details>

<details>
<summary>🌼 Halaman Registrasi Akun</summary>
Halaman ini berfungsi sebagai tempat bagi pengguna baru yang belum memiliki akun untuk melakukan registrasi sebelum dapat mengakses sistem Sistem Monitoring dan Pengelolaan Fasilitas Hijau.
Melalui halaman ini, masyarakat dapat membuat akun dengan mengisi email dan password, yang nantinya tersimpan dalam basis data dan digunakan untuk proses login.

Desain tampilan dibuat sederhana dan interaktif, menampilkan warna hijau alami dengan latar foto aktivitas luar ruang yang menggambarkan interaksi manusia dan lingkungan.
Teks sapaan “Hi, buat akun dulu yok!” memberikan nuansa ramah dan mengajak pengguna untuk bergabung secara positif dalam sistem berbasis lingkungan digital ini.

</details>

<details>
<summary>🌿 Halaman Utama User (User Home Menu)</summary>
Halaman ini merupakan tampilan utama yang akan muncul setelah user berhasil login ke dalam aplikasi Sistem Monitoring dan Pengelolaan Fasilitas Hijau.
Dari halaman ini, pengguna dapat mengakses seluruh fitur utama yang disediakan oleh sistem secara terpusat dan efisien.
Antarmuka didesain dengan visual pepohonan hijau yang tertutup kabut, melambangkan keseimbangan alam dan tanggung jawab bersama dalam menjaga bumi.

**🌱 Fitur Utama pada Halaman User**
1. Laporkan!
- Fitur ini memungkinkan pengguna untuk mengirim laporan lingkungan, seperti area tidak higienis, taman rusak, atau wilayah yang memerlukan perhatian.
- User dapat menambahkan detail laporan, alamat lokasi, serta foto pendukung sebelum dikirim ke sistem.
2. Fasilitas
- Menampilkan daftar fasilitas hijau di sekitar wilayah pengguna, seperti TPA, bank sampah, taman, dan tapak berkelanjutan.
- Data fasilitas diambil langsung dari database dan dapat dilihat berdasarkan kelurahan yang telah terdaftar.
3. Wilayah (Maps View)
- Fitur ini menampilkan peta digital interaktif dengan titik-titik lokasi fasilitas hijau yang telah dimasukkan dalam sistem.
- Melalui tampilan ini, user dapat mengetahui persebaran fasilitas di kotanya serta mendukung evaluasi zona hijau (Hijau – Kuning – Merah).

</details>

<details>
<summary>🌾 Halaman Tambah Laporan (User Add Report)</summary>
Halaman ini merupakan tampilan yang muncul ketika user memilih fitur “Laporkan!” dari menu utama.
Di halaman ini, pengguna dapat mengirim laporan mengenai kondisi lingkungan seperti wilayah kotor, taman rusak, atau fasilitas hijau yang tidak terawat.
Halaman ini menjadi bentuk nyata partisipasi masyarakat dalam mendukung pengelolaan fasilitas hijau berbasis digital, sejalan dengan tujuan Bumi Nusantara Project.

**🌱 Fitur Utama pada Halaman Ini**
1. Form Laporan
- User dapat menulis deskripsi laporan yang menjelaskan kondisi atau masalah yang ditemukan di lapangan.
- Contohnya: “Tempat sampah penuh di taman Samarendah” atau “Rumput taman di kelurahan Air Hitam mulai kering dan tidak terawat.”
2. Kolom Alamat dan Kelurahan
- Pengguna wajib mengisi alamat lengkap lokasi kejadian dan memilih kelurahan sesuai dengan wilayah administratif.
- Data ini membantu sistem dalam mengaitkan laporan dengan wilayah yang tepat.
3. Upload Foto Bukti
- User dapat mengunggah foto kondisi area sebagai bukti visual yang akan tersimpan di basis data.
- Fitur ini membantu admin memverifikasi keaslian laporan.
4. Pilih Lokasi (Tandai pada Peta)
- Pengguna dapat menandai lokasi kejadian dengan cara menjatuhkan pin di peta interaktif.
- Lokasi ini akan otomatis tersimpan dalam atribut latitude dan longitude di database.
5. Tombol “Laporkan!”
- Setelah semua kolom diisi, pengguna dapat menekan tombol ini untuk mengirim laporan ke sistem.
- Data laporan akan tersimpan dan dapat dilihat di menu “Lihat laporan lain”.

</details>

<details>
<summary>🌿 Halaman Fasilitas (User View Fasilitas)</summary>
Halaman ini merupakan tampilan lanjutan dari menu utama user, di mana pengguna dapat melihat berbagai fasilitas hijau yang sudah terdaftar dalam sistem.
Fasilitas yang ditampilkan meliputi berbagai jenis sarana pendukung lingkungan seperti TPA (Tempat Pembuangan Akhir), Bank Sampah, Taman, dan Tapak Berkelanjutan, lengkap dengan informasi nama fasilitas, jenis, lokasi, serta kelurahan tempat fasilitas tersebut berada.

Halaman ini membantu masyarakat untuk lebih mengenal fasilitas hijau di sekitarnya, serta menumbuhkan kesadaran akan pentingnya menjaga dan memanfaatkan sarana lingkungan yang sudah tersedia.

**🌱 Fitur Utama**
1. Tabel Data Fasilitas
- Menampilkan daftar seluruh fasilitas yang tersimpan di database berdasarkan data pada tabel fasilitas.
- Kolom utama terdiri dari Nama, Jenis, Lokasi, dan Kelurahan.
2. Tombol “Lihat Detail”
- Pengguna dapat memilih salah satu fasilitas dan menekan tombol ini untuk menampilkan pop-up detail fasilitas.
- Pop-up akan berisi informasi tambahan seperti kapasitas TPA, nama pengelola bank sampah, kondisi tapak berkelanjutan, atau jam operasional.
3. Tombol “Kembali”
  Mengarahkan user kembali ke halaman utama (User Home Menu).

</details>

<details>
<summary>🌾 Halaman Lihat Laporan (User View Report)</summary>
Halaman ini merupakan bagian dari fitur pelaporan, di mana user dapat melihat seluruh laporan yang telah dikirimkan oleh berbagai pengguna lain dalam sistem Sistem Monitoring dan Pengelolaan Fasilitas Hijau.
Tujuan utama halaman ini adalah memberikan transparansi dan kesadaran lingkungan bersama, sehingga masyarakat bisa mengetahui area-area yang sedang dilaporkan atau membutuhkan perhatian.

Melalui halaman ini, user juga dapat meninjau detail laporan, lokasi, serta foto yang dilampirkan, agar dapat memahami kondisi yang terjadi secara lebih nyata di lapangan.

**🌱 Fitur Utama**
1. Tabel Data Laporan
- Menampilkan daftar laporan yang sudah masuk ke sistem, lengkap dengan kolom ID, Kelurahan, Tanggal Lapor, Lokasi, Foto, Deskripsi, dan Status.
- Data diambil langsung dari tabel laporan pada database.
2. Tombol “Lihat Detail”
- Menampilkan detail isi laporan yang dipilih, termasuk deskripsi dan informasi pelapor (ID User).
3. Tombol “Lihat Lokasi”
- Mengarahkan pengguna ke peta untuk melihat titik lokasi laporan berdasarkan koordinat (latitude dan longitude) yang tersimpan di database.
4. Tombol “Lihat Foto”
- Menampilkan foto bukti laporan dalam bentuk pop-up agar pengguna bisa memverifikasi kondisi lingkungan secara visual.
5. Tombol “Kembali”
- Mengembalikan pengguna ke halaman utama (User Home Menu) dengan satu klik.

</details>

<details>
<summary>🗺️ Halaman Wilayah (User Read Area)</summary>
Halaman User Read Area merupakan fitur yang memungkinkan user melihat kondisi wilayah atau area kelurahan di sekitarnya berdasarkan data fasilitas hijau yang telah tersimpan di sistem Sistem Monitoring dan Pengelolaan Fasilitas Hijau.
Pada halaman ini, setiap wilayah ditampilkan secara visual menggunakan peta dengan indikator zona warna, yang merepresentasikan tingkat keberlanjutan lingkungan berdasarkan jumlah dan kondisi fasilitas hijau di area tersebut.

Fitur ini memberikan gambaran menyeluruh mengenai zona lingkungan (merah, kuning, dan hijau) sehingga pengguna dapat mengetahui daerah mana yang masih perlu perhatian dalam aspek pengelolaan ruang hijau dan kebersihan kota.

**🌱 Fitur Utama**
1. Peta Fullscreen Interaktif
- Menampilkan peta seluruh wilayah dengan penanda fasilitas hijau, titik laporan, serta zona kelurahan.
- Pengguna dapat memperbesar area tertentu untuk melihat lokasi fasilitas lebih detail.
2. Tombol “Kembali”
- Mengembalikan pengguna ke halaman sebelumnya (User Read Area).
3. Integrasi dengan Data Sistem
- Data koordinat (latitude, longitude) diambil langsung dari tabel kelurahan dan fasilitas untuk memastikan akurasi posisi peta.

</details>

<details>
<summary>🗺️ Halaman Peta Wilayah (Full Map View)</summary>
Halaman Full Map View berfungsi sebagai tampilan peta utama yang terhubung langsung dengan seluruh fitur lain yang menampilkan peta dalam sistem Sistem Monitoring dan Pengelolaan Fasilitas Hijau.
Artinya, setiap kali pengguna ingin melihat lokasi fasilitas, titik laporan, maupun zona wilayah, sistem akan mengarahkan atau membuka tampilan peta penuh ini agar informasi bisa dilihat dengan lebih jelas dan menyeluruh.

Halaman ini memudahkan pengguna untuk menavigasi seluruh data spasial dalam satu tempat terintegrasi, baik itu hasil laporan masyarakat, posisi fasilitas hijau, maupun kondisi zona tiap kelurahan.

**🌱 Fitur Utama**
1. Peta Terpadu (Integrated Map View)
- Menampilkan semua data peta dari berbagai fitur:
  - Titik lokasi laporan dari fitur Lihat Laporan.
  - Lokasi fasilitas dari fitur Fasilitas.
  - Zona wilayah dari fitur User Read Area.
- Semua data divisualisasikan secara bersamaan agar pengguna mendapatkan gambaran kondisi wilayah secara utuh.
2. Navigasi Antar-Fitur
- Halaman ini bisa diakses dari beberapa tombol “Lihat Lokasi” pada fitur lain.
- Ketika pengguna memilih lokasi dari laporan atau fasilitas tertentu, sistem otomatis menyorot titik tersebut di peta penuh ini.
3. Tampilan Luas dan Interaktif
- Peta dapat diperbesar atau digeser dengan leluasa untuk melihat area lain.
- Warna indikator tetap konsisten dengan legenda zona (merah–kuning–hijau) dari halaman Wilayah.
4. Tombol “Kembali”
- Mengarahkan pengguna kembali ke fitur asal (Laporan, Fasilitas, atau Wilayah) tanpa kehilangan konteks data yang sedang dibuka.


</details>

<details>
<summary>🖥️ Halaman Utama Admin (Admin Home Menu)</summary>
Halaman Admin Home Menu merupakan tampilan utama yang muncul setelah admin berhasil login ke sistem Sistem Monitoring dan Pengelolaan Fasilitas Hijau – Bumi Nusantara Project.
Halaman ini berfungsi sebagai dashboard pusat kendali bagi admin untuk mengelola seluruh aktivitas sistem, mulai dari verifikasi laporan, pembaruan fasilitas, hingga pemantauan wilayah hijau.

Pada halaman ini, admin disambut dengan sapaan hangat “Hi, selamat datang admin” beserta deskripsi singkat mengenai perannya sebagai pengelola utama sistem.
Selain dua menu utama, Menu Laporan dan Menu Fasilitas, halaman ini juga dilengkapi dengan tampilan peta mini (mini-map) yang dapat menampilkan lokasi seluruh fasilitas secara langsung.

**🌱 Fitur Utama**
1. Menu Laporan
- Mengarahkan admin ke halaman pengelolaan laporan dari user.
- Admin dapat melihat daftar laporan, mengedit data, memperbarui status laporan, atau menghapus laporan yang tidak valid.
2. Menu Fasilitas
- Memberikan akses untuk mengelola data seluruh fasilitas hijau seperti taman, TPA, tapak berkelanjutan, dan bank sampah.
- Admin dapat menambah fasilitas baru, memperbarui informasi, maupun menghapus data lama.
3. Tampilan Peta Mini (Mini Map View) 
- Terletak di bagian bawah halaman utama.
- Menampilkan peta interaktif yang menandai posisi seluruh fasilitas yang tersimpan di database.
- Admin bisa menggeser (scroll/drag) peta untuk menjelajahi area, serta mengklik titik tertentu untuk melihat lokasi lebih detail.
- Jika titik peta diklik dua kali atau diperbesar, sistem akan otomatis membuka Full Map View, yang merupakan tampilan peta besar terintegrasi.
- Fitur ini memudahkan admin melakukan monitoring visual cepat tanpa harus berpindah halaman.
4. Sidebar Navigasi Cepat
- Menyediakan akses ke fitur utama seperti Menu Laporan, Menu Fasilitas, dan Keluar (Logout).
- Desain minimalis agar navigasi tetap efisien dan responsif.

</details>

<details>
<summary>🧾 Halaman Kelola Laporan (Admin Edit Report)</summary>
Halaman Admin Edit Report merupakan tempat bagi admin untuk mengelola seluruh laporan yang dikirim oleh user.
Di halaman ini, admin memiliki akses penuh untuk melihat, mengedit, memperbarui status, hingga menghapus laporan, sesuai kebutuhan.
Tampilan ini didesain agar admin dapat melakukan pengelolaan data dengan cepat dan efisien, disertai antarmuka yang terstruktur dengan baik.

**⚙️ Fitur Utama**
1. Pencarian Berdasarkan ID Laporan
- Admin dapat memasukkan ID laporan pada kolom pencarian untuk menemukan data tertentu dengan cepat.
- Tombol “Cari” berfungsi untuk menampilkan hasil laporan yang relevan, sedangkan tombol “Refresh” digunakan untuk menampilkan ulang seluruh data laporan.
2. Tabel Data Laporan
- Berisi daftar laporan yang dikirim oleh user lengkap dengan kolom ID, Tanggal, Lokasi, Foto, Deskripsi, dan Status.
- Semua data ini terhubung langsung dengan database sehingga pembaruan yang dilakukan akan otomatis tersimpan.
3. Kontrol Aksi CRUD (Create, Read, Update, Delete)
- Lihat Lokasi 🟠 : menampilkan lokasi laporan dalam peta interaktif yang tersambung ke Full Map View.
- Hapus Laporan 🔴 : menghapus laporan yang tidak valid atau sudah tidak diperlukan.
- Lihat Detail 🟡 : menampilkan informasi laporan secara rinci termasuk alamat, deskripsi, dan waktu pengiriman.
- Lihat Foto 🟣 : menampilkan bukti foto yang diunggah user saat membuat laporan.
- Ubah Status ⚙️ : memungkinkan admin memperbarui status laporan (misalnya dari menunggu → diproses → selesai).
4. Navigasi “Kembali”
- Tombol di pojok kiri atas untuk kembali ke halaman utama admin tanpa kehilangan data yang sedang dikelola.

</details>

<details>
<summary>🏗️ Halaman Kelola Fasilitas (Admin Add & Edit Facility)</summary>
Halaman Admin Add & Edit Facility merupakan fitur bagi admin untuk mengelola seluruh data fasilitas hijau yang ada dalam sistem Bumi Nusantara Project.
Melalui halaman ini, admin memiliki kemampuan penuh untuk menambah fasilitas baru, memperbarui data fasilitas yang sudah ada, menghapus fasilitas lama, serta melihat lokasi dan detailnya secara langsung.

Halaman ini menjadi pusat aktivitas pengelolaan data yang terhubung langsung ke tabel fasilitas dalam database, termasuk entitas turunan seperti Bank Sampah, TPA, dan Tapak Berkelanjutan, yang semuanya tercantum pada struktur ERD.

**⚙️ Fitur Utama**
1. Input Data Fasilitas
- Terdiri dari beberapa kolom penting:
  - Nama Fasilitas 
  - Jenis Fasilitas (dropdown berisi pilihan seperti Taman, Bank Sampah, Tapak Berkelanjutan, TPA)
  - Lokasi 
  - Kelurahan 
- Semua data ini wajib diisi sebelum menambahkan fasilitas baru.
2. Tombol Aksi CRUD (Create, Read, Update, Delete)
- Tambah Fasilitas 🟢 : digunakan untuk menambahkan data fasilitas baru.
- Perbarui Fasilitas 🔵 : mengedit atau memperbarui informasi fasilitas yang sudah terdaftar.
- Hapus Fasilitas 🔴 : menghapus data fasilitas yang sudah tidak aktif atau tidak relevan.
- Pilih Lokasi 🟣 : membuka tampilan peta (terhubung dengan Full Map View) untuk menandai titik lokasi fasilitas baru.
- Lihat Detail 🟡 : menampilkan rincian lengkap dari fasilitas yang dipilih, termasuk jenis, lokasi, dan kelurahannya.
3. Tabel Data Fasilitas
- Menampilkan daftar seluruh fasilitas yang tersimpan di sistem, meliputi kolom Nama, Jenis, Lokasi, dan Kelurahan.
- Data pada tabel ini diperbarui secara dinamis setelah admin menambah, mengedit, atau menghapus data fasilitas.
4. Navigasi Kembali
- Tombol “Kembali” di bagian atas memungkinkan admin untuk kembali ke halaman utama tanpa kehilangan data yang telah diinput.

</details>
