-- noinspection SqlNoDataSourceInspectionForFile

INSERT INTO recipe(title, description, body)
VALUES ('Gefülltes Fladenbrot', 'Gefülltes Fladenbrot mit Schafskäse, Gurken und Krautsalat',
        '= Document Title
Pingu <pingu@pongu.com>

== The documents provides:
=== The documents provides:

Das ist ein normaler Paragraph. Mit mehreren Sätzen.
Und mehreren Zeilen. SO wie es sein sollte, bla bla bla Lorem Ipsum Dolockuhokuspokus

* List
** List
*** List

Die Liste sollte hier zuende sein.

. List
. List
.. List
.. List
.. List

Warum muss man jede Liste mit Text beenden? Aber egal einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text,
einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text,
einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text Hurraaaaaaaa!!!!

Ein AQbsatz

Warum muss man jede Liste mit Text beenden? Aber egal einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text,
einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text,
einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text einfach mehr Text Hurraaaaaaaa!!!!

* [*] List
* [ ] List


.Das ist ein toller Titel
|===
|Name of Column 1 |Name of Column 2 |Name of Column 3

|Cell in column 1, row 1
|Cell in column 2, row 1
|Cell in column 3, row 1

|Cell in column 1, row 2
|Cell in column 2, row 2
|Cell in column 3, row 2
|===

* Link: https://asciidoctor.org - automatic!
* Link: link:++https://example.org/?q=[a b]++[URL with special characters]

* Bold: *Bold*
* Italic: _Italic_
* Monospace: `Monospace`

* #Hash Hash#
* [.underline]#Underline#
* [.line-through]#Line-Through#

* Super^script^
* Sub~script~'),
       ('Pizza', 'Italienische Pizza', '=== Belag

* Tomatensauße
* Salami');

INSERT INTO ingredient(title, type)
VALUES ('Karotten', 'VEGETABLE'),
       ('Salami', 'MEAT');
