DROP TABLE IF EXISTS recipe;
CREATE TABLE recipe (
    recipe_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    recipe_title text NOT NULL,
    recipe_descr text NOT NULL,
    recipe_body text NOT NULL
);

DROP TABLE IF EXISTS ingredient;
CREATE TABLE ingredient (
    ingr_id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    ingr_title text NOT NULL,
    ingr_type text NOT NULL
);

DROP TABLE IF EXISTS ingredient_usage;
CREATE TABLE ingredient_usage (
    recipe_id int REFERENCES recipe (recipe_id) ON UPDATE CASCADE ON DELETE CASCADE, -- Delete entries if recipe gets deleted
    ingr_id int REFERENCES ingredient (ingr_id) ON UPDATE CASCADE, -- Kepp entries if ingredient gets deleted
    CONSTRAINT ingredient_usage_pk PRIMARY KEY (recipe_id, ingr_id)
);

-- DATA INSERTION ##################################################################################

INSERT INTO recipe(recipe_title, recipe_descr, recipe_body)
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

INSERT INTO ingredient(ingr_title, ingr_type)
VALUES ('Karotten', 'VEGETABLE'),
       ('Salami', 'MEAT');
