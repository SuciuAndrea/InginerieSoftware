# Design Patterns 

## Singleton Pattern
Singleton Pattern a fost folosit pentru clasa `Market` deoarece aplicația trebuie să aibă o singură piață de tranzacționare. Toți utilizatorii văd aceleași acțiuni și criptomonede, cu aceleași prețuri, iar acest pattern asigură că nu pot exista mai multe instanțe diferite ale pieței. În felul acesta se evită situațiile în care datele ar putea fi inconsistente.

## Factory / Simple Factory Pattern
Factory Pattern a fost folosit pentru crearea obiectelor de tip `Stock` și `Crypto`. În loc să creez aceste obiecte direct în mai multe locuri din cod, logica de creare este separată într-o singură zonă. Astfel, codul este mai ușor de extins și, dacă pe viitor ar apărea un nou tip de asset, acesta ar putea fi adăugat fără să fie nevoie de modificări majore.

## Strategy Pattern
Strategy Pattern este folosit pentru implementarea diferitelor strategii de trading, cum ar fi day trading, long-term investing și auto trading. Acest pattern permite schimbarea strategiei în timpul rulării aplicației, direct din meniu, fără a modifica logica principală. Fiecare strategie are propriul comportament, iar aplicația poate trece ușor de la una la alta.

## Observer Pattern
Observer Pattern a fost folosit pentru funcționalitățile de notificare și auto trading. Clasa `Market` notifică automat observatorii atunci când prețul unui asset se schimbă. `Watchlist` folosește acest mecanism pentru a afișa notificări, iar `AutoTradingStrategy` pentru a cumpăra sau vinde automat. Acest pattern ajută la decuplarea logicii de actualizare a prețurilor de reacțiile care apar în urma acestor schimbări.

## Facade Pattern
Facade Pattern este folosit prin clasa `Market`, care oferă o interfață simplă pentru interacțiunea cu piața. În loc ca alte clase să gestioneze direct liste de assets sau observatori, ele comunică doar cu Market. Acest lucru face codul mai clar și mai ușor de înțeles.

## Composite Pattern (conceptual)
Composite Pattern este folosit la nivel conceptual în implementarea portofoliului utilizatorului. Portofoliul gestionează mai multe assets și le tratează ca pe un singur obiect, permițând operații precum buy, sell sau afișare fără a ține cont de tipul specific al fiecărui asset. Acest lucru simplifică modul în care este gestionat portofoliul.
