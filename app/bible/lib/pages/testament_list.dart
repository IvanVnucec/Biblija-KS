import 'package:bible/res/colors.dart';
import 'package:flutter/material.dart';

ListTile testamentBookContainer(String bookName) {
  return ListTile(
    title: Text(bookName),
    textColor: MyColors.appBarForegroundColor,
    onTap: () {},
  );
}

class ListOldTestamentBooks extends StatelessWidget {
  static var oldTestamentBooksSortedList = <Widget>[
      testamentBookContainer('Knjiga Postanka'),
      testamentBookContainer('Knjiga Izlaska'),
      testamentBookContainer('Levitski zakonik'),
      testamentBookContainer('Knjiga Brojeva'),
      testamentBookContainer('Ponovljeni zakon'),
      testamentBookContainer('Jošua'),
      testamentBookContainer('Knjiga o Sucima'),
      testamentBookContainer('Knjiga o Ruti'),
      testamentBookContainer('Prva knjiga o Samuelu'),
      testamentBookContainer('Druga knjiga o Samuelu'),
      testamentBookContainer('Prva knjiga o Kraljevima'),
      testamentBookContainer('Druga knjiga o Kraljevima'),
      testamentBookContainer('Prva Knjiga Ljetopisa'),
      testamentBookContainer('Druga Knjiga Ljetopisa'),
      testamentBookContainer('Ezra'),
      testamentBookContainer('Nehemija'),
      testamentBookContainer('Tobija'),
      testamentBookContainer('Judita'),
      testamentBookContainer('Estera'),
      testamentBookContainer('Prva knjiga o Makabejcima'),
      testamentBookContainer('Druga knjiga o Makabejcima'),
      testamentBookContainer('Knjiga o Jobu'),
      testamentBookContainer('Psalmi'),
      testamentBookContainer('Mudre izreke'),
      testamentBookContainer('Propovjednik'),
      testamentBookContainer('Pjesma nad pjesmama'),
      testamentBookContainer('Knjiga Mudrosti'),
      testamentBookContainer('Knjiga Sirahova'),
      testamentBookContainer('Izaija'),
      testamentBookContainer('Jeremija'),
      testamentBookContainer('Tužaljke'),
      testamentBookContainer('Baruh'),
      testamentBookContainer('Ezekiel'),
      testamentBookContainer('Daniel'),
      testamentBookContainer('Hošea'),
      testamentBookContainer('Joel'),
      testamentBookContainer('Amos'),
      testamentBookContainer('Obadija'),
      testamentBookContainer('Jona'),
      testamentBookContainer('Mihej'),
      testamentBookContainer('Nahum'),
      testamentBookContainer('Habakuk'),
      testamentBookContainer('Sefanija'),
      testamentBookContainer('Hagaj'),
      testamentBookContainer('Zaharija'),
      testamentBookContainer('Malahija'),
      //testamentBookContainer('Evanđelje po Mateju'),
      //testamentBookContainer('Evanđelje po Marku'),
      //testamentBookContainer('Evanđelje po Luki'),
      //testamentBookContainer('Evanđelje po Ivanu'),
      //testamentBookContainer('Djela apostolska'),
      //testamentBookContainer('Poslanica Rimljanima'),
      //testamentBookContainer('Prva poslanica Korinćanima'),
      //testamentBookContainer('Druga poslanica Korinćanima'),
      //testamentBookContainer('Poslanica Galaćanima'),
      //testamentBookContainer('Poslanica Efežanima'),
      //testamentBookContainer('Poslanica Filipljanima'),
      //testamentBookContainer('Poslanica Kološanima'),
      //testamentBookContainer('Prva poslanica Solunjanima'),
      //testamentBookContainer('Druga poslanica Solunjanima'),
      //testamentBookContainer('Prva poslanica Timoteju'),
      //testamentBookContainer('Druga poslanica Timoteju'),
      //testamentBookContainer('Poslanica Titu'),
      //testamentBookContainer('Poslanica Filemonu'),
      //testamentBookContainer('Poslanica Hebrejima'),
      //testamentBookContainer('Jakovljeva poslanica'),
      //testamentBookContainer('Prva Petrova poslanica'),
      //testamentBookContainer('Druga Petrova poslanica'),
      //testamentBookContainer('Prva Ivanova poslanica'),
      //testamentBookContainer('Druga Ivanova poslanica'),
      //testamentBookContainer('Treća Ivanova poslanica'),
      //testamentBookContainer('Poslanica Jude apostola'),
      //testamentBookContainer('Otkrivenje'),
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
