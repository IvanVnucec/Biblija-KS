"""
Download all the bible text from http://www.ks.hr/hr-biblija-text/ into bible folder.
Caution: This might overload their servers because no delay is implemented. Use with caution.
"""

import requests
from bs4 import BeautifulSoup
from pathlib import Path

class Book:
    def __init__(self, name='', url='') -> None:
        self.name = name
        self.url = url
        self.chapters = []

class Chapter:
    def __init__(self, name='', url='') -> None:
        self.name = name
        self.url = url
        self.html = ''

class Bible:
    def __init__(self) -> None:
        self.books = []

KS_URL = "http://www.ks.hr/hr-biblija-text/"

bible = Bible()

req = requests.get(KS_URL)
soup = BeautifulSoup(req.content, 'html.parser')
aa = soup.find_all('a')[4:]
book_names = [a.get_text() for a in aa]
for book_name in book_names:
    book_url = KS_URL + book_name + '/'
    bible.books.append(Book(name=book_name, url=book_url))

for book in bible.books:
    #print(book.name, book.url)
    req = requests.get(book.url)
    soup = BeautifulSoup(req.content, 'html.parser')
    aa = soup.find_all('a')[4:]
    chapter_names = [a.get_text().replace(".html", "") for a in aa]
    for chapter_name in chapter_names:
        chapter_url = book.url + chapter_name + ".html"
        book.chapters.append(Chapter(name=chapter_name, url=chapter_url))
        #print('\t', chapter_name, chapter_url)

for book in bible.books:
    print(book.name, book.url)
    for chapter in book.chapters:
        req = requests.get(chapter.url)
        chapter.html = str(BeautifulSoup(req.content, 'html.parser'))
        print('\t', chapter.name, chapter.url)

BIBLE_PATH = 'bible'
Path(BIBLE_PATH).mkdir(parents=True, exist_ok=True)
for book in bible.books:
    book_name = book.name.replace("__", "_") # some strings have two underscores
    book_path = f"{BIBLE_PATH}/{book_name}"
    Path(book_path).mkdir(parents=True, exist_ok=True)
    print(book_path)
    for chapter in book.chapters:
        chapter_name = chapter.name.replace("__", "_")
        chapter_filename = chapter_name + ".html"
        chapter_path = f"{book_path}/{chapter_filename}"
        print('\t', chapter_path)
        with open(chapter_path, "w") as file:
            file.write(chapter.html)

