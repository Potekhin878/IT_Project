# Tajemství starého domu – textová adventura

Tato hra je jednoduchá textová adventura, ve které se hráč pohybuje mezi místnostmi starého domu, sbírá předměty, komunikuje s postavami a snaží se vyřešit hlavní úkol. Herní svět je načítán ze souboru `svet.json`, který obsahuje seznam místností, jejich popisy a propojení.

## Ovládání hry (příkazy)

Hráč zadává příkazy do konzole. Každý příkaz může mít parametry.

Dostupné příkazy:

| Příkaz                | Popis                                                                 |
|-----------------------|------------------------------------------------------------------------|
| `jdi <směr>`          | Přesun do jiné místnosti (např. `jdi sever`, `jdi kuchyne`)           |
| `seber <předmět>`     | Sebere přenosný předmět z místnosti                                   |
| `poloz <předmět>`     | Položí předmět z inventáře do místnosti                               |
| `inventar`            | Vypíše obsah hráčova inventáře                                        |
| `mluv <postava>`      | Zahájí rozhovor s postavou v místnosti                                |
| `pouzij <předmět>`    | Použije předmět z inventáře                                           |
| `napoveda`            | Vypíše seznam dostupných příkazů                                      |
| `konec`               | Ukončí hru                                                            |

## Herní mechaniky

- Pohyb mezi místnostmi pomocí příkazu `jdi`.
- Některé místnosti mají speciální podmínky (např. sklep je přístupný pouze s baterkou).
- Předměty mohou být přenosné i nepřenosné.
- Postavy poskytují rady nebo reagují na předměty, které jim hráč přinese.
- Cílem hry je najít správné předměty, komunikovat s postavami a splnit hlavní úkol.

## Jak hru spustit

1. Ujistěte se, že máte nainstalovanou Java (doporučeno Java 17+).
2. Stáhněte / naklonujte repozitář.
3. V příkazové řádce přejděte do složky, kde se nachází `.jar` soubor:

   ```bash
   cd cesta/k/souboru

4. Spusťte hru příkazem:

   ```bash
   java -jar IT_Project.jar

5. Po spuštění se zobrazí úvodní text a popis první místnosti.

## Použité knihovny:

Gson (com.google.gson) – pro načítání a zpracování JSON souboru `svet.json`.

## Struktura projektu:

`Main.java` – vstupní bod programu

`Hra.java` – hlavní herní logika

`Svet.java` – načítání světa a logika místností

`SpravcePrikazu.java` – zpracování příkazů

`Prikaz*` – jednotlivé implementace příkazů

`svet.json` – definice místností a jejich propojení