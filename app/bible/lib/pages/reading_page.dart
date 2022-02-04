import 'package:bible/res/colors.dart';
import 'package:flutter/material.dart';

class ReadingPage extends StatefulWidget {
  final String chapterPath;

  const ReadingPage(this.chapterPath, {Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() => _ReadingPage();
}

class _ReadingPage extends State<ReadingPage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
          // TODO: add text here
          title: const Text('Glava 1/Glava 2 etc...'),
          foregroundColor: MyColors.appBarForegroundColor,
          backgroundColor: MyColors.testamentButtonBackgroundColors[0]),
      body: Container(
        padding: const EdgeInsets.fromLTRB(8.0, 2.0, 8.0, 0.0),
        child: SingleChildScrollView(
          scrollDirection: Axis.vertical,
          child: Text(
            // TODO: load text here
            "sasgfaegaedgfadfgdafgadv" * 1000,
            style: const TextStyle(
              fontSize: 18.0,
              color: MyColors.appBarForegroundColor,
            ),
          ),
        ),
      ),
      backgroundColor: MyColors.homeBackgroundColor,
    );
  }
}
