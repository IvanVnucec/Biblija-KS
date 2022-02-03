import 'package:bible/pages/chapter_list.dart';
import 'package:bible/res/colors.dart';
import 'package:bible/widgets/list_tile.dart';
import 'package:flutter/material.dart';

class ListOldTestamentBooks extends StatelessWidget {
  static late BuildContext _context;

  static Future<void> changeContextOnTap(String bookPath) async {
    Navigator.push(_context,
        MaterialPageRoute(builder: (context) => ChaptersList(bookPath)));
  }

  static var oldTestamentBooksSortedList = <Widget>[
    TestamentBookListTile(
        'Knjiga Postanka', 'bible/Knjiga_Postanka', changeContextOnTap),
    TestamentBookListTile(
        'Knjiga Izlaska', 'bible/Izlazak', changeContextOnTap),
    TestamentBookListTile(
        'Levitski zakonik', 'bible/Levitski_zakonik', changeContextOnTap),
    TestamentBookListTile(
        'Knjiga Brojeva', 'bible/Brojevi', changeContextOnTap),
    TestamentBookListTile(
        'Ponovljeni zakon', 'bible/Ponovljeni_zakon', changeContextOnTap),
    TestamentBookListTile('Jošua', 'bible/Josua', changeContextOnTap),
    TestamentBookListTile('Knjiga o Sucima', 'bible/Suci', changeContextOnTap),
    TestamentBookListTile('Knjiga o Ruti', 'bible/Ruta', changeContextOnTap),
    TestamentBookListTile(
        'Prva knjiga o Samuelu', 'bible/Samuel_I', changeContextOnTap),
    TestamentBookListTile(
        'Druga knjiga o Samuelu', 'bible/Samuel_II', changeContextOnTap),
    TestamentBookListTile(
        'Prva knjiga o Kraljevima', 'bible/Kraljevi_I', changeContextOnTap),
    TestamentBookListTile(
        'Druga knjiga o Kraljevima', 'bible/Kraljevi_II', changeContextOnTap),
    TestamentBookListTile(
        'Prva Knjiga Ljetopisa', 'bible/Ljetopisi_I', changeContextOnTap),
    TestamentBookListTile(
        'Druga Knjiga Ljetopisa', 'bible/Ljetopisi_II', changeContextOnTap),
    TestamentBookListTile('Ezra', 'bible/Ezra', changeContextOnTap),
    TestamentBookListTile('Nehemija', 'bible/Nehemija', changeContextOnTap),
    TestamentBookListTile('Tobija', 'bible/Tobija', changeContextOnTap),
    TestamentBookListTile('Judita', 'bible/Judita', changeContextOnTap),
    TestamentBookListTile('Estera', 'bible/Estera', changeContextOnTap),
    TestamentBookListTile(
        'Prva knjiga o Makabejcima', 'bible/Makabejci_I', changeContextOnTap),
    TestamentBookListTile(
        'Druga knjiga o Makabejcima', 'bible/Makabejci_II', changeContextOnTap),
    TestamentBookListTile('Knjiga o Jobu', 'bible/Job', changeContextOnTap),
    TestamentBookListTile('Psalmi', 'bible/Psalmi', changeContextOnTap),
    TestamentBookListTile('Mudre izreke', 'bible/Izreke', changeContextOnTap),
    TestamentBookListTile(
        'Propovjednik', 'bible/Propovjednik', changeContextOnTap),
    TestamentBookListTile(
        'Pjesma nad pjesmama', 'bible/Pjesma_nad_pjesmama', changeContextOnTap),
    TestamentBookListTile(
        'Knjiga Mudrosti', 'bible/Mudrost', changeContextOnTap),
    TestamentBookListTile('Knjiga Sirahova', 'bible/Sirah', changeContextOnTap),
    TestamentBookListTile('Izaija', 'bible/Izaija', changeContextOnTap),
    TestamentBookListTile('Jeremija', 'bible/Jeremija', changeContextOnTap),
    TestamentBookListTile('Tužaljke', 'bible/Tuzaljke', changeContextOnTap),
    TestamentBookListTile('Baruh', 'bible/Baruh', changeContextOnTap),
    TestamentBookListTile('Ezekiel', 'bible/Ezekiel', changeContextOnTap),
    TestamentBookListTile('Daniel', 'bible/Daniel', changeContextOnTap),
    TestamentBookListTile('Hošea', 'bible/Hosea', changeContextOnTap),
    TestamentBookListTile('Joel', 'bible/Joel', changeContextOnTap),
    TestamentBookListTile('Amos', 'bible/Amos', changeContextOnTap),
    TestamentBookListTile('Obadija', 'bible/Obadija', changeContextOnTap),
    TestamentBookListTile('Jona', 'bible/Jona', changeContextOnTap),
    TestamentBookListTile('Mihej', 'bible/Mihej', changeContextOnTap),
    TestamentBookListTile('Nahum', 'bible/Nahum', changeContextOnTap),
    TestamentBookListTile('Habakuk', 'bible/Habakuk', changeContextOnTap),
    TestamentBookListTile('Sefanija', 'bible/Sefanija', changeContextOnTap),
    TestamentBookListTile('Hagaj', 'bible/Hagaj', changeContextOnTap),
    TestamentBookListTile('Zaharija', 'bible/Zaharija', changeContextOnTap),
    TestamentBookListTile('Malahija', 'bible/Malahija', changeContextOnTap),
    //TestamentBookListTile('Evanđelje po Mateju', 'bible/Matej', changeContextOnTap),
    //TestamentBookListTile('Evanđelje po Marku', 'bible/Marko', changeContextOnTap),
    //TestamentBookListTile('Evanđelje po Luki', 'bible/Luka', changeContextOnTap),
    //TestamentBookListTile('Evanđelje po Ivanu', 'bible/Ivan', changeContextOnTap),
    //TestamentBookListTile('Djela apostolska', 'bible/Djela', changeContextOnTap),
    //TestamentBookListTile('Poslanica Rimljanima', 'bible/Rimljanima', changeContextOnTap),
    //TestamentBookListTile('Prva poslanica Korinćanima', 'bible/Korincanima_I', changeContextOnTap),
    //TestamentBookListTile('Druga poslanica Korinćanima', 'bible/Korincanima_II', changeContextOnTap),
    //TestamentBookListTile('Poslanica Galaćanima', 'bible/Galacanima', changeContextOnTap),
    //TestamentBookListTile('Poslanica Efežanima', 'bible/Efezanima', changeContextOnTap),
    //TestamentBookListTile('Poslanica Filipljanima', 'bible/Filipljanima', changeContextOnTap),
    //TestamentBookListTile('Poslanica Kološanima', 'bible/Kolosanima', changeContextOnTap),
    //TestamentBookListTile('Prva poslanica Solunjanima', 'bible/Solunjanima_I', changeContextOnTap),
    //TestamentBookListTile('Druga poslanica Solunjanima', 'bible/Solunjanima_II', changeContextOnTap),
    //TestamentBookListTile('Prva poslanica Timoteju', 'bible/Timoteju_I', changeContextOnTap),
    //TestamentBookListTile('Druga poslanica Timoteju', 'bible/Timoteju_II', changeContextOnTap),
    //TestamentBookListTile('Poslanica Titu', 'bible/Titu', changeContextOnTap),
    //TestamentBookListTile('Poslanica Filemonu', 'bible/Filemonu', changeContextOnTap),
    //TestamentBookListTile('Poslanica Hebrejima', 'bible/Hebrejima', changeContextOnTap),
    //TestamentBookListTile('Jakovljeva poslanica', 'bible/Jakovljeva_poslanica', changeContextOnTap),
    //TestamentBookListTile('Prva Petrova poslanica',    ble/I._Petrova_poslanica', changeContextOnTap),
    //TestamentBookListTile('Druga Petrova poslanica',    ble/II._Petrova_poslanica', changeContextOnTap),
    //TestamentBookListTile('Prva Ivanova poslanica',    ble/I._Ivanova_poslanica', changeContextOnTap),
    //TestamentBookListTile('Druga Ivanova poslanica',    ble/II._Ivanova_poslanica', changeContextOnTap),
    //TestamentBookListTile('Treća Ivanova poslanica',    ble/III._Ivanova_poslanica', changeContextOnTap),
    //TestamentBookListTile('Poslanica Jude apostola', 'bible/Poslanica_Jude_apostola', changeContextOnTap),
    //TestamentBookListTile('Otkrivenje', 'bible/Otkrivenje'),
  ];

  const ListOldTestamentBooks({Key? key}) : super(key: key);

  static ListView booksList = ListView(
    padding: const EdgeInsets.all(8),
    children: oldTestamentBooksSortedList,
  );

  @override
  Widget build(BuildContext context) {
    _context = context;

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
