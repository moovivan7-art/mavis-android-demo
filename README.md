# Mavis Android Demo

Демо-приложение на Android (Java, без внешних зависимостей). APK уже собран и проверен:
пакет `com.mavis.demo`, minSdk 24, targetSdk 34, подпись debug.

## Что в репозитории
- `app/` — исходники приложения
- `deploy/build-in-sandbox.sh` — сборка APK прямо в песочнице агента (JDK 17 + SDK 34 + Gradle 8.7)
- `deploy/build-apk-workflow.yml` — вариант сборки через GitHub Actions

## Как поставить на телефон
1. Скачай `app-debug.apk` (файл приложен в чат).
2. На телефоне: Настройки → Разрешения → «Установка неизвестных приложений» → разрешить
   для приложения, из которого открываешь файл (браузер/мессенджер).
3. Открой файл → «Установить».

## Если хочешь сборку через GitHub Actions
Коннектор агента не даёт писать в `.github/workflows/` — это ограничение инструмента.
Открой `deploy/build-apk-workflow.yml` на GitHub → «Add file → Create new file» →
путь `.github/workflows/build-apk.yml` → вставь → commit. Дальше каждый push в `main`
собирает APK и кладёт его в Releases.
