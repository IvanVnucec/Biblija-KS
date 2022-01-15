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
            foregroundColor: Colors.black,
            backgroundColor: Colors.white,
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
        backgroundColor: Colors.black,
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
                    gradient: LinearGradient(
                      colors: <Color>[
                        Color(0xFF0D47A1),
                        Color(0xFF1976D2),
                        Color(0xFF42A5F5)
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
