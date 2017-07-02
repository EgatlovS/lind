import { GettingStartedPage } from './app.po';

describe('getting-started App', () => {
  let page: GettingStartedPage;

  beforeEach(() => {
    page = new GettingStartedPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
