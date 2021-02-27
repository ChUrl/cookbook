INSERT INTO recipes (recipe_id, recipe_title, recipe_descr, recipe_body)
VALUES ('1a9196f4-088c-42e5-9a06-e30f7a8630f9', 'Kartoffelsalat', 'Ein Salat aus Kartoffeln, der Kartoffeln beinhaltet.',
'### Benötigte Zutaten
<hr>

1. Kartoffeln
2. Mehr Kartoffeln
3. Salat
4. Man braucht auch noch 1EL Kartoffeln

### Zubereitung
<hr>

- Kartoffeln schälen
- Die Schale essen

++PlusPlus++<br>
~~TildeTilde~~<br>
*Stern*<br>
**SternStern**<br>
***SternSternStern***<br>
<mark>MarkTag</mark><br>
https://google.de');

INSERT INTO ingredients (ingr_id, ingr_title, ingr_type)
VALUES ('08d710e3-c619-4ccb-9984-b665b2ba88d9', 'Kartoffeln', 4),
       ('9bdcd68f-3894-45ff-bcbb-474cf11753a2', 'Karotten', 4);

INSERT INTO ingredient_usages (ingr_id, recipe_id, amount)
VALUES ('08d710e3-c619-4ccb-9984-b665b2ba88d9', '1a9196f4-088c-42e5-9a06-e30f7a8630f9', 25),
       ('9bdcd68f-3894-45ff-bcbb-474cf11753a2', '1a9196f4-088c-42e5-9a06-e30f7a8630f9', 12);
