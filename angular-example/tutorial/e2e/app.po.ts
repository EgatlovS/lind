import { browser, element, by } from 'protractor';

export class TutorialPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('lt-root h1')).getText();
  }
}
