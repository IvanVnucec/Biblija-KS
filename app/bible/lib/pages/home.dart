import 'package:bible/pages/settings.dart';
import 'package:bible/pages/testament_list.dart';
import 'package:flutter/material.dart';

class MyHome extends StatelessWidget {
  const MyHome({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Biblija',
      home: Scaffold(
        appBar: AppBar(
            foregroundColor: Colors.white,
            backgroundColor: const Color.fromRGBO(35, 35, 35, 1.0),
            title: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                const Text('Biblija'),
                IconButton(
                  icon: const Icon(Icons.settings),
                  onPressed: () {
                    Navigator.push(
                        context,
                        MaterialPageRoute(
                            builder: (context) => const MySettings()));
                  },
                ),
              ],
            )),
        backgroundColor: const Color.fromRGBO(22, 22, 22, 1.0),
        body: Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              TestamentButtons(
                title: 'Stari zavjet',
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => const ListOldTestamentBooks()),
                  );
                },
              ),
              TestamentButtons(
                title: 'Novi zavjet',
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                        builder: (context) => const ListNewTestamentBooks()),
                  );
                },
              ),
            ],
          ),
        ),
      ),
      debugShowCheckedModeBanner: false,
    );
  }
}

class TestamentButtons extends ClipRRect {
  TestamentButtons(
      {required String title, required VoidCallback? onPressed, Key? key})
      : super(
          key: key,
          borderRadius: BorderRadius.circular(10),
          child: Stack(
            children: <Widget>[
              Positioned.fill(
                child: Container(
                  decoration: const BoxDecoration(
                    gradient: RadialGradient(
                      radius: 3.0,
                      colors: <Color>[
                        Color.fromRGBO(114, 9, 183, 1.0),
                        Color.fromRGBO(72, 12, 168, 1.0),
                      ],
                    ),
                  ),
                ),
              ),
              TextButton(
                style: TextButton.styleFrom(
                  padding: const EdgeInsets.all(20.0),
                  primary: Colors.white,
                  textStyle: const TextStyle(
                      fontSize: 25, fontWeight: FontWeight.w500),
                ),
                onPressed: onPressed,
                child: Text(title),
              ),
            ],
          ),
        );
}
