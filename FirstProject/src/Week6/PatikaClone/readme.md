Patika  klonu
Details 
Proje - Patika Klonu
Eğitmen Paneli
- [ ] Eğitmenler sisteme giriş yaptıklarında, görevlerini yapabilecekleri bir ekran tasarlanmalı.
	- [ ] logout button
	- [ ] Eğitmenler Operatörler tarafından kendilerine atanan eğitimleri görüp listeleyebilirler. Eğitimleri düzenleme veya silme yetkileri bulunmaz. Başka eğitmenlere ait eğitimleride göremezler.
	- [ ] Eğitmenlerin görevi eğitimlere içerik eklemek olacaktır. (Bknz : patika.dev sistesinde ki Java 102 Eğitimi)
	- [ ] Eğitmenler içerik ekleyip kendilerine ait olan içerikleri düzenleyip, silebilirler ve listeleyebilirler.
		- [ ] delete
		- [ ] update
		- [ ] İçeriklerin özellikleri :
			- [ ] İçeriğin ait olduğu ders bilgisi
				- [ ] tabledan hangisi seçiliyse o. seçili değilse seçsin.
			- [ ] İçerik Başlığı
			- [ ] İçerik Açıklaması
			- [ ] İçerik Youtube Linki
			- [ ] İçerik Quiz Soruları 
			- [ ] Quiz soruları eğitmen panelinden eklenecektir ve soruyu eklerken hangi içeriğe ait olduğu seçilmelidir. 
				- [ ] table right click pop up menu ordan add quiz question. Sonra zaten aynı courseları çeker gibi tüm o content ile alakalı questionları çek. Gene content seçilmediyse ilk önce seçmesini söyle. yani table needed: question. answer. contentid
	- [ ] İçerik listeleme ekranında, derslere göre ve içerik başlığına göre filtreleme yapılabilmeli.
		- [ ] when click on course it shows contents of it at another table below
	- [ ] Eğitmen tüm bu işleri arayüz üzerinden yapmalıdır.
Öğrenci Paneli
- [ ] Öğrenciler sisteme giriş yaptıklarında, aynı sizlerinde yaptığı gibi patikalar üzerinden derslere erişmeliler.
	- [ ] Öğrenciler sistemdeki patikaları listeleyebilir.
	- [ ] Öğrenciler patikalar üzerinden bir derse kayıt olmalıdır.
	- [ ] Öğrenciler kayıt oldukları derse ait içeriklere ulaşabilir ve görüntüleyebilir. (Youtube videosunu proje içerisine gömmeye gerek yoktur sadece link verilebilir)
		- [ ] make a page and side panel. in side panel when you select a path go in that. select a course go in that select a content and load the page. its like tree folder system. and add a home button to go back to paths page. 
		- [ ] headline, desc, video, quiz
	- [ ] Öğrenciler derslere ait içerikleri değerlendirebilir ve yorum yapabilir.
		- [ ] table needed with selected content.
	- [ ] Öğrenciler derslere ait quizleri çözebilir.
	- [ ] Öğrenciler tüm bu işleri arayüz üzerinden yapmalıdır.
Operatör Paneline Ekleme
- [ ] Operatörler, sistemdeki tüm patikaları, eğitimleri, içerikleri ve quizleri silme, düzenleme yetkisine sahiptir.
	- [ ] yani content tab ı ve quiz tab ı eklenecek
Giriş Ekranına Ekleme
- [ ] Öğrenciler giriş ekranı sırasında üyelikleri yok ise sisteme kayıt olabilirler.
- [ ] Kayıt ol ekranı tasarlanmalı ve sadece öğrenciler sisteme kayıt yapabilmeli.
- [ ] Sistemdeki operatörleri yazılımcı (Yani sizler) eklemeli, eğitmenleride sadece operatörler ekleyebilmeli.

