import 'package:bible/res/colors.dart';
import 'package:flutter/material.dart';

class MyListTile extends ListTile {
  MyListTile(String bookName, String bookPath, Function onTap, {Key? key})
      : super(
          key: key,
          title: Text(bookName),
          textColor: MyColors.appBarForegroundColor,
          onTap: () {
            onTap(bookPath);
          },
        );
}

class TestamentBookListTile extends MyListTile {
  TestamentBookListTile(String bookName, String bookPath, Function onTap, {Key? key})
      : super(bookName, bookPath, onTap, key: key, 
      );
}
