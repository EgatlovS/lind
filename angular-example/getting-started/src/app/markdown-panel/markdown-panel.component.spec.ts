import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MarkdownPanelComponent } from './markdown-panel.component';

describe('MarkdownPanelComponent', () => {
  let component: MarkdownPanelComponent;
  let fixture: ComponentFixture<MarkdownPanelComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MarkdownPanelComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MarkdownPanelComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
