# Patika  klonu
## Homework - We did only operatorGUI with teacher.
###### I leaved undone what i think is some kind of unnecessary.
### Eğitmen Paneli
- [x] Eğitmenler sisteme giriş yaptıklarında, görevlerini yapabilecekleri bir ekran tasarlanmalı.
	- [x] logout button
	- [x] Eğitmenler Operatörler tarafından kendilerine atanan eğitimleri görüp listeleyebilirler. Eğitimleri düzenleme veya silme yetkileri bulunmaz. Başka eğitmenlere ait eğitimleride göremezler.
	- [x] Eğitmenlerin görevi eğitimlere içerik eklemek olacaktır. (Bknz : patika.dev sistesinde ki Java 102 Eğitimi)
	- [x] Eğitmenler içerik ekleyip kendilerine ait olan içerikleri düzenleyip, silebilirler ve listeleyebilirler.
		- [x] delete
		- [x] update
		- [x] İçeriklerin özellikleri :
			- [x] İçeriğin ait olduğu ders bilgisi
				- [x] tabledan hangisi seçiliyse o. seçili değilse seçsin.
			- [x] İçerik Başlığı
			- [x] İçerik Açıklaması
			- [x] İçerik Youtube Linki
			- [x] İçerik Quiz Soruları 
			- [x] Quiz soruları eğitmen panelinden eklenecektir ve soruyu eklerken hangi içeriğe ait olduğu seçilmelidir. 
				- [x] table right click pop up menu ordan add quiz question. Sonra zaten aynı courseları çeker gibi tüm o content ile alakalı questionları çek. Gene content seçilmediyse ilk önce seçmesini söyle. yani table needed: question. answer. contentid
	- [x] İçerik listeleme ekranında, derslere göre ve içerik başlığına göre filtreleme yapılabilmeli.
		- [x] when click on course it shows contents of it at another table below
	- [x] Eğitmen tüm bu işleri arayüz üzerinden yapmalıdır.
### Öğrenci Paneli
- [x] Öğrenciler sisteme giriş yaptıklarında, aynı sizlerinde yaptığı gibi patikalar üzerinden derslere erişmeliler.
	- [x] Öğrenciler sistemdeki patikaları listeleyebilir.
	- [x] Öğrenciler patikalar üzerinden bir derse kayıt olmalıdır.
	- [x] Öğrenciler kayıt oldukları derse ait içeriklere ulaşabilir ve görüntüleyebilir. (Youtube videosunu proje içerisine gömmeye gerek yoktur sadece link verilebilir)
		- [x] make a page and side panel. in side panel when you select a path go in that. select a course go in that select a content and load the page. its like tree folder system. and add a home button to go back to paths page. 
		- [x] headline, desc, video, quiz
	- [ ] Öğrenciler derslere ait içerikleri değerlendirebilir ve yorum yapabilir.
		- [ ] table needed with selected content.
	- [x] Öğrenciler derslere ait quizleri çözebilir.
	- [x] Öğrenciler tüm bu işleri arayüz üzerinden yapmalıdır.
### Operatör Paneline Ekleme
- [ ] Operatörler, sistemdeki tüm patikaları, eğitimleri, içerikleri ve quizleri silme, düzenleme yetkisine sahiptir.
	- [ ] yani content tab ı ve quiz tab ı eklenecek
### Giriş Ekranına Ekleme
- [x] Öğrenciler giriş ekranı sırasında üyelikleri yok ise sisteme kayıt olabilirler.
- [x] Kayıt ol ekranı tasarlanmalı ve sadece öğrenciler sisteme kayıt yapabilmeli.
- [x] Sistemdeki operatörleri yazılımcı (Yani sizler) eklemeli, eğitmenleride sadece operatörler ekleyebilmeli.

