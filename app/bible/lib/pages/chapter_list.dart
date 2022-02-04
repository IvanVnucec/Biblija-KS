import 'dart:io';

import 'package:bible/pages/reading_page.dart';
import 'package:bible/res/colors.dart';
import 'package:bible/widgets/list_tile.dart';
import 'package:flutter/material.dart';

class ChaptersList extends StatefulWidget {
  final String bookPath;

  const ChaptersList(this.bookPath, {Key? key}) : super(key: key);

  @override
  State<StatefulWidget> createState() => _ChaptersListState();
}

class _ChaptersListState extends State<ChaptersList> {
  static late BuildContext _context;

  static void changeContextOnTap(String chapterPath) {
    Navigator.push(_context,
        MaterialPageRoute(builder: (context) => ReadingPage(chapterPath)));
  }

  @override
  Widget build(BuildContext context) {
    _context = context;
    // TODO: get files list
    return Scaffold(
      appBar: AppBar(
          // TODO: add New Testament or old testament title text
          title: const Text('New Testament/Old Testament'),
          foregroundColor: MyColors.appBarForegroundColor,
          backgroundColor: MyColors.testamentButtonBackgroundColors[0]),
      body: Center(
        child: ListView(
          children: [
            TestamentBookListTile("Glava 1", "", (String chapterPath) {
              changeContextOnTap(chapterPath);
            }),
            TestamentBookListTile("Glava 2", "", (String chapterPath) {
              changeContextOnTap(chapterPath);
            }),
            TestamentBookListTile("Glava 3", "", (String chapterPath) {
              changeContextOnTap(chapterPath);
            }),
            TestamentBookListTile("Glava 4", "", (String chapterPath) {
              changeContextOnTap(chapterPath);
            }),
          ],
        ),
      ),
      backgroundColor: MyColors.homeBackgroundColor,
    );
  }

  // TODO: test me
  Future<Iterable<File>> getListOfFilesInDir(String path) async {
    final dir = Directory(path);
    final List<FileSystemEntity> entities = await dir.list().toList();
    return entities.whereType<File>();
  }
}
