import 'package:bible/res/colors.dart';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class TestamentBookListTile extends ListTile {
  TestamentBookListTile(String bookName, String bookPath, {Key? key})
      : super(
          key: key,
          title: Text(bookName),
          textColor: MyColors.appBarForegroundColor,
          onTap: () async {
            // TODO: load text from assets and switch context
            /*
            String asd = await rootBundle.loadString(
                'assets/bible/Knjiga_Postanka/Knjiga_Postanka_-_1.html');
            */
          },
        );
}

class ListOldTestamentBooks extends StatelessWidget {
  static var oldTestamentBooksSortedList = <Widget>[
    TestamentBookListTile('Knjiga Postanka', 'bible/Knjiga_Postanka'),
    TestamentBookListTile('Knjiga Izlaska', 'bible/Izlazak'),
    TestamentBookListTile('Levitski zakonik', 'bible/Levitski_zakonik'),
    TestamentBookListTile('Knjiga Brojeva', 'bible/Brojevi'),
    TestamentBookListTile('Ponovljeni zakon', 'bible/Ponovljeni_zakon'),
    TestamentBookListTile('Jošua', 'bible/Josua'),
    TestamentBookListTile('Knjiga o Sucima', 'bible/Suci'),
    TestamentBookListTile('Knjiga o Ruti', 'bible/Ruta'),
    TestamentBookListTile('Prva knjiga o Samuelu', 'bible/Samuel_I'),
    TestamentBookListTile('Druga knjiga o Samuelu', 'bible/Samuel_II'),
    TestamentBookListTile('Prva knjiga o Kraljevima', 'bible/Kraljevi_I'),
    TestamentBookListTile('Druga knjiga o Kraljevima', 'bible/Kraljevi_II'),
    TestamentBookListTile('Prva Knjiga Ljetopisa', 'bible/Ljetopisi_I'),
    TestamentBookListTile('Druga Knjiga Ljetopisa', 'bible/Ljetopisi_II'),
    TestamentBookListTile('Ezra', 'bible/Ezra'),
    TestamentBookListTile('Nehemija', 'bible/Nehemija'),
    TestamentBookListTile('Tobija', 'bible/Tobija'),
    TestamentBookListTile('Judita', 'bible/Judita'),
    TestamentBookListTile('Estera', 'bible/Estera'),
    TestamentBookListTile('Prva knjiga o Makabejcima', 'bible/Makabejci_I'),
    TestamentBookListTile('Druga knjiga o Makabejcima', 'bible/Makabejci_II'),
    TestamentBookListTile('Knjiga o Jobu', 'bible/Job'),
    TestamentBookListTile('Psalmi', 'bible/Psalmi'),
    TestamentBookListTile('Mudre izreke', 'bible/Izreke'),
    TestamentBookListTile('Propovjednik', 'bible/Propovjednik'),
    TestamentBookListTile('Pjesma nad pjesmama', 'bible/Pjesma_nad_pjesmama'),
    TestamentBookListTile('Knjiga Mudrosti', 'bible/Mudrost'),
    TestamentBookListTile('Knjiga Sirahova', 'bible/Sirah'),
    TestamentBookListTile('Izaija', 'bible/Izaija'),
    TestamentBookListTile('Jeremija', 'bible/Jeremija'),
    TestamentBookListTile('Tužaljke', 'bible/Tuzaljke'),
    TestamentBookListTile('Baruh', 'bible/Baruh'),
    TestamentBookListTile('Ezekiel', 'bible/Ezekiel'),
    TestamentBookListTile('Daniel', 'bible/Daniel'),
    TestamentBookListTile('Hošea', 'bible/Hosea'),
    TestamentBookListTile('Joel', 'bible/Joel'),
    TestamentBookListTile('Amos', 'bible/Amos'),
    TestamentBookListTile('Obadija', 'bible/Obadija'),
    TestamentBookListTile('Jona', 'bible/Jona'),
    TestamentBookListTile('Mihej', 'bible/Mihej'),
    TestamentBookListTile('Nahum', 'bible/Nahum'),
    TestamentBookListTile('Habakuk', 'bible/Habakuk'),
    TestamentBookListTile('Sefanija', 'bible/Sefanija'),
    TestamentBookListTile('Hagaj', 'bible/Hagaj'),
    TestamentBookListTile('Zaharija', 'bible/Zaharija'),
    TestamentBookListTile('Malahija', 'bible/Malahija'),
    //TestamentBookListTile('Evanđelje po Mateju', 'bible/Matej'),
    //TestamentBookListTile('Evanđelje po Marku', 'bible/Marko'),
    //TestamentBookListTile('Evanđelje po Luki', 'bible/Luka'),
    //TestamentBookListTile('Evanđelje po Ivanu', 'bible/Ivan'),
    //TestamentBookListTile('Djela apostolska', 'bible/Djela'),
    //TestamentBookListTile('Poslanica Rimljanima', 'bible/Rimljanima'),
    //TestamentBookListTile('Prva poslanica Korinćanima', 'bible/Korincanima_I'),
    //TestamentBookListTile('Druga poslanica Korinćanima', 'bible/Korincanima_II'),
    //TestamentBookListTile('Poslanica Galaćanima', 'bible/Galacanima'),
    //TestamentBookListTile('Poslanica Efežanima', 'bible/Efezanima'),
    //TestamentBookListTile('Poslanica Filipljanima', 'bible/Filipljanima'),
    //TestamentBookListTile('Poslanica Kološanima', 'bible/Kolosanima'),
    //TestamentBookListTile('Prva poslanica Solunjanima', 'bible/Solunjanima_I'),
    //TestamentBookListTile('Druga poslanica Solunjanima', 'bible/Solunjanima_II'),
    //TestamentBookListTile('Prva poslanica Timoteju', 'bible/Timoteju_I'),
    //TestamentBookListTile('Druga poslanica Timoteju', 'bible/Timoteju_II'),
    //TestamentBookListTile('Poslanica Titu', 'bible/Titu'),
    //TestamentBookListTile('Poslanica Filemonu', 'bible/Filemonu'),
    //TestamentBookListTile('Poslanica Hebrejima', 'bible/Hebrejima'),
    //TestamentBookListTile('Jakovljeva poslanica', 'bible/Jakovljeva_poslanica'),
    //TestamentBookListTile('Prva Petrova poslanica',    ble/I._Petrova_poslanica'),
    //TestamentBookListTile('Druga Petrova poslanica',    ble/II._Petrova_poslanica'),
    //TestamentBookListTile('Prva Ivanova poslanica',    ble/I._Ivanova_poslanica'),
    //TestamentBookListTile('Druga Ivanova poslanica',    ble/II._Ivanova_poslanica'),
    //TestamentBookListTile('Treća Ivanova poslanica',    ble/III._Ivanova_poslanica'),
    //TestamentBookListTile('Poslanica Jude apostola', 'bible/Poslanica_Jude_apostola'),
    //TestamentBookListTile('Otkrivenje', 'bible/Otkrivenje'),
  ];

  const ListOldTestamentBooks({Key? key}) : super(key: key);

  static ListView booksList = ListView(
    padding: const EdgeInsets.all(8),
    children: oldTestamentBooksSortedList,
  );

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Stari zavjet'),
        foregroundColor: MyColors.appBarForegroundColor,
        backgroundColor: MyColors.testamentButtonBackgroundColors[0],
      ),
      body: Center(
        child: booksList,
      ),
      backgroundColor: MyColors.homeBackgroundColor,
    );
  }
}

class ListNewTestamentBooks extends StatelessWidget {
  const ListNewTestamentBooks({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Second Route'),
      ),
      body: Center(
        child: ElevatedButton(
          onPressed: () {
            Navigator.pop(context);
          },
          child: const Text('Go back!'),
        ),
      ),
    );
  }
}
