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
      ),
      body: Center(
        child: Text(widget.bookPath),
        ),
      );
  }
}
