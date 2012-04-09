package org.basex.gui.dialog;

import static org.basex.core.Text.*;
import static org.basex.gui.layout.BaseXKeys.*;

import java.awt.*;
import java.awt.event.*;

import org.basex.data.*;
import org.basex.gui.GUIConstants.Msg;
import org.basex.gui.layout.*;
import org.basex.util.*;
import org.basex.util.list.*;

/**
 * Rename database/drop documents dialog.
 *
 * @author BaseX Team 2005-12, BSD License
 * @author Christian Gruen
 */
public final class DialogInput extends Dialog {
  /** User input. */
  private final BaseXTextField input;
  /** Old input. */
  private final String old;
  /** Buttons. */
  private final BaseXBack buttons;
  /** Info label. */
  private final BaseXLabel info;
  /** Available databases. */
  private final StringList db;
  /** Rename/copy/delete dialog. */
  private final int type;

  /**
   * Default constructor.
   * @param o old input
   * @param tit title string
   * @param d dialog window
   * @param t type of dialog (rename database/copy database/drop documents)
   */
  public DialogInput(final String o, final String tit, final Dialog d, final int t) {
    super(d, tit);
    old = o;
    db = d.gui.context.databases().listDBs();
    type = t;

    String title = "";
    if(type == 0) {
      title = TARGET_PATH + COLS;
    } else if(type == 1) {
      title = NAME_OF_DB + COLS;
    } else if(type == 2) {
      title = NAME_OF_DB_COPY + COLS;
    }

    set(new BaseXLabel(title, false, true).border(0, 0, 6, 0),
        BorderLayout.NORTH);

    input = new BaseXTextField(o, this);
    input.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(final KeyEvent e) {
        if(!modifier(e)) action(ENTER.is(e) ? e.getSource() : null);
      }
    });
    info = new BaseXLabel(" ");

    final BaseXBack p = new BaseXBack(new BorderLayout(0, 8));
    p.add(input, BorderLayout.NORTH);
    p.add(info, BorderLayout.CENTER);
    set(p, BorderLayout.CENTER);

    buttons = newButtons(B_OK, B_CANCEL);
    set(buttons, BorderLayout.SOUTH);
    action(null);
    finish(null);
  }

  /**
   * Returns the user input.
   * @return input
   */
  public String input() {
    return input.getText().trim();
  }

  @Override
  public void action(final Object cmp) {
    final String in = input();
    String msg = null;
    ok = type != 0 && (db.contains(in) || in.equals(old));
    if(ok) msg = Util.info(DB_EXISTS_X, in);
    if(!ok) {
      ok = type == 0 ? MetaData.normPath(in) != null :
          MetaData.validName(in, false);
      if(!ok) msg = in.isEmpty() ? ENTER_DB_NAME : Util.info(INVALID_X, NAME);
    }

    info.setText(msg, type == 1 || type == 2 ? Msg.ERROR : Msg.WARN);
    enableOK(buttons, B_OK, ok);
  }

  @Override
  public void close() {
    if(ok) super.close();
  }
}
