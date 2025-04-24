# 🎮 Gioco del Tris (Tic Tac Toe)

Una semplice implementazione del gioco del **Tris** (conosciuto anche come Tic Tac Toe), sviluppata in Java con interfaccia **testuale via console**. Supporta due giocatori in locale e tiene traccia delle vittorie.

---

## ✅ Specifiche Funzionali

### 🎲 Modalità di gioco
- Il gioco è pensato per **2 giocatori in locale**.
- L’interfaccia è **testuale** (tutto avviene tramite la console).
- I giocatori si alternano inserendo coordinate (es: `0,0`) per posizionare:
  - `X` per il **Giocatore 1**
  - `O` per il **Giocatore 2**

### 🎯 Input del giocatore
- Le coordinate devono essere nel formato `riga,colonna` con valori tra `0` e `2`.
- Il programma:
  - Verifica il **formato dell’input**
  - Controlla se la **casella è libera**
  - In caso di errore, richiede un nuovo input

### 🏆 Vittoria e pareggio
- Dopo ogni mossa (a partire dalla terza), il programma controlla se c’è un vincitore.
- Il gioco termina immediatamente se un giocatore vince.
- Se tutte le celle sono occupate e nessuno ha vinto, la partita termina in **pareggio**.

### 🖼️ Visualizzazione
- Dopo ogni mossa, la **griglia viene aggiornata** e stampata in console.
