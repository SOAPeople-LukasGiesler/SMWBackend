# SMWBackend
Backend für das SmartWorkbench Projekt

Die Kommunikation des Backend mit dem Frontend erfolgt über eine REST-API.

URI des Webservice: 
    http://46.237.197.145:8080/Backend/webresources/instructions

Eine entsprechende GET-Anfrage an die URI liefert die Baupläne im JSON Format.

---

Eine PUT Anfrage den Webservice dient dazu, dass das Frontend Benutzeraktionen an das Backend weiterleiten kann. 
Der PUT Anfrage kann ein Parameter 'step' hinzugefügt werden um die Aktionen weiterzuleiten. 

Übersicht der PUT-Anfragen:

    - Start der Montage der Zahnbürste:
      http://46.237.197.145:8080/Backend/webresources/instructions?step=Zahnbuerste
    
    - Start der Montage der Schraubzwinge: 
      http://46.237.197.145:8080/Backend/webresources/instructions?step=Schraubzwinge

    - Nächster Schritt
      http://46.237.197.145:8080/Backend/webresources/instructions?step=nextStep

Das Backend regelt entsprechend die Montage der Bauteile und steuert die Kommunikation mit den PIs.

