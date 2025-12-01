# Kontenplan

Web-basierte Anwendung zur Erstellung und Verwaltung eines beliebigen Kontenplans zu Buchhaltungszwecken.

## Ziel
Es soll ein Kontenplan erstellt werden können, der Konten unter einer Kontenklasse einordnet. Zwischen Konten und Kontenklassen sollen Kontenkategorien beliebig tief geschachtelt werden können.


Hier ist ein beispielhafter Auszug aus einem Kontenplan, der durch die Software abgebildet werden soll.

![Auszug aus dem Verwaltungskontenrahmen](./docs/coa-snippet.png "Auszug aus dem Verwaltungskontenrahmen des Bundesfinanzministeriums")

## Datenmodell

Zunächst soll eine Minimalimplementierung erfolgen.

![Entity-Relationship-Diagram und Relationales Modell](./docs/datamodels/GL_Account.BOTH.drawio.png "Entity-Relationship-Diagram und Relationales Modell")