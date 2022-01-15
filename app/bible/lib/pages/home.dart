import 'package:bible/pages/settings.dart';
import 'package:bible/pages/testament_list.dart';
import 'package:bible/res/colors.dart';
import 'package:flutter/material.dart';

class MyHome extends StatelessWidget {
  const MyHome({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Biblija',
      home: Scaffold(
        appBar: AppBar(
            foregroundColor: MyColors.appBarForegroundColor,
            backgroundColor: MyColors.appBarBackgroundColor,
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
        backgroundColor: MyColors.homeBackgroundColor,
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
                      colors: MyColors.testamentButtonBackgroundColors,
                    ),
                  ),
                ),
              ),
              TextButton(
                style: TextButton.styleFrom(
                  padding: const EdgeInsets.all(20.0),
                  primary: MyColors.testamentButtonTextColor,
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
