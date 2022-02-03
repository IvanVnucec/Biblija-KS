import 'dart:io';

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
  @override
  Widget build(BuildContext context) {
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
            TestamentBookListTile("Glava 1", "", (String book_path) {}),
            TestamentBookListTile("Glava 2", "", (String book_path) {}),
            TestamentBookListTile("Glava 3", "", (String book_path) {}),
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
